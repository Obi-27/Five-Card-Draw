#!/bin/bash

SRC_DIR="src"
TEST_DIR="tests"
LIB_DIR="lib"
BIN_DIR="bin"
JUNIT_VERSION=""
JUNIT_JAR="$LIB_DIR/junit-platform-console-standalone-1.13.0-M3.jar"

#Check if JUNIT_JAR exists
if [ ! -f "$JUNIT_JAR" ]; then
    echo "JUNIT NOT FOUND"
    exit 1
fi

#create bin directory
rm -rf "$BIN_DIR"
mkdir -p "$BIN_DIR"

#Compile the source code
find $SRC_DIR -name "*.java" > sources.txt
javac -d "$BIN_DIR" @sources.txt

#Compile the test code
find $TEST_DIR -name "*.java" > test_sources.txt
javac -cp "$JUNIT_JAR:$BIN_DIR" -d "$BIN_DIR" @test_sources.txt

#run tests
java -jar lib/junit-platform-console-standalone-1.13.0-M3.jar \
  execute \
  --class-path bin \
  --scan-class-path

