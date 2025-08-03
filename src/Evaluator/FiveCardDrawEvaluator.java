package Evaluator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.*;


/*
 * THis class provides a method to evaluate hands according to the rules of Five Card Draw
 */
public class FiveCardDrawEvaluator {
    public enum Ranks {
        STRAIGHT_FLUSH,
        FOUR_OF_A_KIND,
        FULL_HOUSE,
        FLUSH,
        STRAIGHT,
        THREE_OF_A_KIND,
        TWO_PAIR,
        ONE_PAIR,
        HIGH_CARD;
    }

    /**
     * This method converts a card to its value for the game FiveCardDraw (Ace High)
     * 
     * @ param card the current card
     * @ return the value of the card
     */
    private static int getCardValue(Card card) {
        int value;
        switch (card.getRank()) {
            case TWO: value = 2; break;
            case THREE: value = 3; break;
            case FOUR: value = 4; break;
            case FIVE: value = 5; break;
            case SIX: value = 6; break;
            case SEVEN: value = 7; break;
            case EIGHT: value = 8; break;
            case NINE: value = 9; break;
            case TEN: value = 10; break;
            case JACK: value = 11; break;
            case QUEEN: value = 12; break;
            case KING: value = 13; break;
            case ACE: value = 14; break;
            default: value = 0;
        }
        return value;
    }


    /**
     *This method calculates the strength of a given hand
     *
     * @param Hand the players hand
     * @return the rank of the hand
     */
    public static Ranks evaluateHand(Hand hand) {
        List<Card> cards = hand.getCards();
        Map<Card.Rank, Integer> rankCount = new HashMap<>();
        Map<Card.Suit, Integer> suitCount = new HashMap<>();
        List<Integer> cardValues = new ArrayList<>();
    

        for (Card card : cards) {
            rankCount.put(card.getRank(), rankCount.getOrDefault(card.getRank(),0) + 1);
            suitCount.put(card.getSuit(), suitCount.getOrDefault(card.getSuit(),0) + 1);
            cardValues.add(getCardValue(card));
        }

        boolean isFlush = suitCount.size() == 1;

        //sort values in order and check for consecutive rank
        Collections.sort(cardValues);
        boolean isStraight = true;
        for(int i = 1; i < cardValues.size(); i++) {
            if(cardValues.get(i) != cardValues.get(i - 1) + 1) {
                isStraight = false;
                break;
            }
        }

        //Check hand strength from best to worst
        if(isStraight && isFlush) return Ranks.STRAIGHT_FLUSH;
        if(rankCount.containsValue(4)) return Ranks.FOUR_OF_A_KIND;
        if(rankCount.containsValue(3) && rankCount.containsValue(2)) return Ranks.FULL_HOUSE;
        if(isFlush) return Ranks.FLUSH;
        if(isStraight) return Ranks.STRAIGHT;
        if(rankCount.containsValue(3)) return Ranks.THREE_OF_A_KIND;


        int numPairs = 0;
        for(int count: rankCount.values()) {
            if(count == 2) numPairs++;
        }

        if(numPairs == 2) return Ranks.TWO_PAIR;
        if(numPairs == 1) return Ranks.ONE_PAIR;

        return Ranks.HIGH_CARD;
    }
}