package blackjack;

import java.util.*;

public class Deck {
    List<Card> cards = new ArrayList<Card>();

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public void shuffle() {
        // shuffle cards
    }

    public Card draw() {
        return null;
    }

    public List<Card> draw(int n) {
        if(!cards.isEmpty()) {
            Card res = cards.get(0);
            cards.remove(0);
            return res;
        } else {
            throw new Exception("Empty!");
        }
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for(Card card : cards) 
            sb.append(card.toString() + ", ");

        if(sb.length() > 2) 
            sb.setLength(sb.length() - 2);
        sb.append("]");
        return sb.toString();
    }
}
