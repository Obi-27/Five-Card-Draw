package model;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private final List<Card> cards = new ArrayList<>();
    private int curIndex = 0;   

    public Deck() {
        for (Card.Suit suit : Card.Suit.values()) {
            for (Card.Rank rank : Card.Rank.values()) {
                    cards.add(new Card(rank, suit));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
        curIndex = 0;
    }

    public Card dealCard() {
        if (curIndex < cards.size()) {
            return cards.get(curIndex++);
        } else {
            throw new IllegalStateException();
        }
    }
}
