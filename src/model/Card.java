package model;


/*
 * This class represents a card object
 * It stores information about a cards suit and rank
 */
public class Card {
    public enum Suit {
        CLUBS,
        DIAMONDS,
        HEARTS,
        SPADES
    }

    public enum Rank {
        TWO,
        THREE,
        FOUR,
        FIVE,
        SIX,
        SEVEN,
        EIGHT,
        NINE,
        TEN,
        JACK,
        QUEEN,
        KING,
        ACE;
    }

    private final Suit suit;
    private final Rank rank;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public Suit getSuit() { return this.suit; }
    public Rank getRank() { return this.rank; }

    private String suitIcon(Suit suitType) {
        String suitIcon;
        switch (suit) {
            case HEARTS: suitIcon = "♥"; break;
            case DIAMONDS: suitIcon = "♦"; break;
            case SPADES: suitIcon = "♠"; break;
            case CLUBS: suitIcon = "♣"; break;
            default: suitIcon = " ";
        }

        return suitIcon;
    }

    public String toString() {
        return rank.name() + suitIcon(suit);
    }
}
