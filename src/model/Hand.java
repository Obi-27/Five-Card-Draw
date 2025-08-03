package model;
import java.util.ArrayList;
import java.util.List;


/*
 * This class represents a players hand
 * it contains the cards a player currently has
 */
public class Hand {
    private final List<Card> cards;

    public Hand(List<Card> cards) {
        this.cards = new ArrayList<>(cards);
    }

    public List<Card> getCards() {
        return cards;
    }

    public String toString() {
        StringBuilder handString = new StringBuilder();
        for(Card card: cards) {
            handString.append(card + " ");
        }
        return handString.toString();
    }
}
