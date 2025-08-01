package tests.Evaluator;

import java.util.Arrays;
import model.*;
import org.junit.*;

import Evaluator.FiveCardDrawEvaluator;

public class FiveCardDrawEvaluatorTest {
    @Test
    public void evaluateStraightFlush() {
        Hand hand = new Hand(Arrays.asList(
            new Card(Card.Rank.SEVEN, Card.Suit.CLUBS),
            new Card(Card.Rank.EIGHT, Card.Suit.CLUBS),
            new Card(Card.Rank.NINE, Card.Suit.CLUBS),
            new Card(Card.Rank.TEN, Card.Suit.CLUBS),
            new Card(Card.Rank.JACK, Card.Suit.CLUBS)
        ));

        Assert.assertEquals(FiveCardDrawEvaluator.Ranks.STRAIGHT_FLUSH, FiveCardDrawEvaluator.evaluateHand(hand));
    }


    @Test
    public void evaluateFourOfAKind() {
        Hand hand = new Hand(Arrays.asList(
            new Card(Card.Rank.KING, Card.Suit.CLUBS),
            new Card(Card.Rank.KING, Card.Suit.SPADES),
            new Card(Card.Rank.KING, Card.Suit.HEARTS),
            new Card(Card.Rank.KING, Card.Suit.DIAMONDS),
            new Card(Card.Rank.JACK, Card.Suit.CLUBS)
        ));

        Assert.assertEquals(FiveCardDrawEvaluator.Ranks.FOUR_OF_A_KIND, FiveCardDrawEvaluator.evaluateHand(hand));
    }


    @Test
    public void evaluateFullHouse() {
        Hand hand = new Hand(Arrays.asList(
            new Card(Card.Rank.EIGHT, Card.Suit.CLUBS),
            new Card(Card.Rank.EIGHT, Card.Suit.DIAMONDS),
            new Card(Card.Rank.EIGHT, Card.Suit.HEARTS),
            new Card(Card.Rank.KING, Card.Suit.SPADES),
            new Card(Card.Rank.KING, Card.Suit.CLUBS)
        ));

        Assert.assertEquals(FiveCardDrawEvaluator.Ranks.FULL_HOUSE, FiveCardDrawEvaluator.evaluateHand(hand));
    }


    @Test
    public void evaluateFlush() {
        Hand hand = new Hand(Arrays.asList(
            new Card(Card.Rank.TWO, Card.Suit.CLUBS),
            new Card(Card.Rank.FOUR, Card.Suit.CLUBS),
            new Card(Card.Rank.SIX, Card.Suit.CLUBS),
            new Card(Card.Rank.EIGHT, Card.Suit.CLUBS),
            new Card(Card.Rank.TEN, Card.Suit.CLUBS)
        ));

        Assert.assertEquals(FiveCardDrawEvaluator.Ranks.FLUSH, FiveCardDrawEvaluator.evaluateHand(hand));
    }


    @Test
    public void evaluateStraight() {
        Hand hand = new Hand(Arrays.asList(
            new Card(Card.Rank.TWO, Card.Suit.CLUBS),
            new Card(Card.Rank.THREE, Card.Suit.HEARTS),
            new Card(Card.Rank.FOUR, Card.Suit.DIAMONDS),
            new Card(Card.Rank.FIVE, Card.Suit.CLUBS),
            new Card(Card.Rank.SIX, Card.Suit.SPADES)
        ));

        Assert.assertEquals(FiveCardDrawEvaluator.Ranks.STRAIGHT, FiveCardDrawEvaluator.evaluateHand(hand));
    }


    @Test
    public void evaluateThreeOFAKind() {
        Hand hand = new Hand(Arrays.asList(
            new Card(Card.Rank.ACE, Card.Suit.CLUBS),
            new Card(Card.Rank.ACE, Card.Suit.HEARTS),
            new Card(Card.Rank.ACE, Card.Suit.DIAMONDS),
            new Card(Card.Rank.SIX, Card.Suit.SPADES),
            new Card(Card.Rank.SEVEN, Card.Suit.HEARTS)
        ));

        Assert.assertEquals(FiveCardDrawEvaluator.Ranks.THREE_OF_A_KIND, FiveCardDrawEvaluator.evaluateHand(hand));
    }

    @Test
    public void evaluateTwoPair() {
        Hand hand = new Hand(Arrays.asList(
            new Card(Card.Rank.SEVEN, Card.Suit.CLUBS),
            new Card(Card.Rank.SEVEN, Card.Suit.DIAMONDS),
            new Card(Card.Rank.NINE, Card.Suit.CLUBS),
            new Card(Card.Rank.QUEEN, Card.Suit.CLUBS),
            new Card(Card.Rank.QUEEN, Card.Suit.HEARTS)
        ));

        Assert.assertEquals(FiveCardDrawEvaluator.Ranks.TWO_PAIR, FiveCardDrawEvaluator.evaluateHand(hand));
    }

    @Test
    public void evaluateOnePair() {
        Hand hand = new Hand(Arrays.asList(
            new Card(Card.Rank.SEVEN, Card.Suit.HEARTS),
            new Card(Card.Rank.EIGHT, Card.Suit.CLUBS),
            new Card(Card.Rank.EIGHT, Card.Suit.DIAMONDS),
            new Card(Card.Rank.TEN, Card.Suit.CLUBS),
            new Card(Card.Rank.JACK, Card.Suit.SPADES)
        ));

        Assert.assertEquals(FiveCardDrawEvaluator.Ranks.ONE_PAIR, FiveCardDrawEvaluator.evaluateHand(hand));
    }


    @Test
    public void evaluateHighCard() {
        Hand hand = new Hand(Arrays.asList(
            new Card(Card.Rank.KING, Card.Suit.CLUBS),
            new Card(Card.Rank.TWO, Card.Suit.HEARTS),
            new Card(Card.Rank.JACK, Card.Suit.SPADES),
            new Card(Card.Rank.SIX, Card.Suit.DIAMONDS),
            new Card(Card.Rank.SEVEN, Card.Suit.DIAMONDS)
        ));

        Assert.assertEquals(FiveCardDrawEvaluator.Ranks.HIGH_CARD, FiveCardDrawEvaluator.evaluateHand(hand));
    }
}
