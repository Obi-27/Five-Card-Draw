package Games;

import java.util.ArrayList;
import java.util.List;

import Evaluator.FiveCardDrawEvaluator;
import model.*;

public class FiveCardDraw {
    public void play() {
        Deck deck = new Deck();
        deck.shuffle();

        System.out.print("Shuffling ... Shuffling ... Shuffling ... ");

        List<Card> drawnCards = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
            drawnCards.add(deck.dealCard());
        }

        Hand playerHand = new Hand(drawnCards);
        System.out.println("Your Hand: " + playerHand);

        FiveCardDrawEvaluator.Ranks result = FiveCardDrawEvaluator.evaluateHand(playerHand);
        System.out.println("You have: " + result);
    }
}