#!/bin/bash

SRC_DIR="src"
TEST_DIR="tests"
LIB_DIR="lib"
BIN_DIR="bin"
JUNIT_VERSION=""
JUNIT_JAR="$LIB_DIR/junit-platform-console-standalone-1.13.0-M3.jar"


#create bin directory
rm -rf "$BIN_DIR"
mkdir -p "$BIN_DIR"

#Compile the source code
find $SRC_DIR -name "*.java" > sources.txt
javac -d "$BIN_DIR" @sources.txt

#Compile the test code
find $TEST_DIR -name "*.java" > test_sources.txt
javac -cp "$JUNIT_JAR:$BIN_DIR" -d "$BIN_DIR" @test_sources.txt

if [ "$#" -eq 0 ] || [ "$1" == "FiveCardDraw" ]; then
  #run the game
  java -cp "$BIN_DIR" Main

elif [ "$1" == "-test" ]; then

  #Check if JUNIT_JAR exists
  if [ ! -f "$JUNIT_JAR" ]; then
      echo "JUNIT NOT FOUND"
      exit 1
  fi

  #run tests
  java -jar lib/junit-platform-console-standalone-1.13.0-M3.jar \
    execute \
    --class-path bin \
    --scan-class-path
elif [ "$1" == "help" ]; then
  echo "Usage: ./run.sh [OPTION]"
  echo
  echo "Options:"
  echo "  FiveCardDraw    Run the Five Card Draw poker game (default)"
  echo "  -test           Compile and run all unit tests using JUnit 5"
  echo "  -help           Show this help message and exit"
  echo
  echo "Examples:"
  echo "  ./run.sh               Run the default poker game"
  echo "  ./run.sh FiveCardDraw  Run the poker game explicitly"
  echo "  ./run.sh -test         Run unit tests"
  echo "  ./run.sh -help         Show help instructions"
  exit 0
fi




