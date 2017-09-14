/*
Rohit Singh
111056206
CSE 114
Project
 */
import java.util.ArrayList;
import java.util.Collections;

public class Deck extends Card {

    public ArrayList<Card> deck = new ArrayList<Card>();

    public Deck() {
        for (int i = 1; i < 8; i++) {
            for (int j = 0; j < 4; j++) {
                switch (j) {
                    case 0:
                        deck.add(new Card("Red", i));
                        break;
                    case 1:
                        deck.add(new Card("Green", i));
                        break;
                    case 2:
                        deck.add(new Card("Blue", i));
                        break;
                    case 3:
                        deck.add(new Card("Yellow", i));
                        break;
                }
            }
        }
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public void draw(ArrayList<Card> deck, ArrayList<Card> currDeck) {

        currDeck.add(deck.get(deck.size() - 1));
        deck.remove(deck.size() - 1);
    }

    public void putBack(ArrayList<Card> deck, ArrayList<Card> currDeck) {
        for (int i = 0; i < currDeck.size(); i++) {
            deck.add(currDeck.get(i));
            currDeck.remove(i);
        }
    }

    public void distribute(ArrayList<Card> playerDeck, ArrayList<Card> compDeck) {
        for (int j = 0, i = (deck.size() - 1); j < 10; j++, i--) {
            if (i % 2 == 0) {
                playerDeck.add(deck.get(i));
                deck.remove(i);
            } else {
                compDeck.add(deck.get(i));
                deck.remove(i);
            }
        }
    }

    public boolean firstTurn(ArrayList<Card> deck, ArrayList<Card> compDeck, ArrayList<Card> playerDeck) {
        if (playerDeck.get(0).getNumber() > compDeck.get(0).getNumber()) {
            return true;
        } else if (playerDeck.get(0).getNumber() == compDeck.get(0).getNumber()) {
            putBack(deck, playerDeck);
            putBack(deck, compDeck);
            shuffle(deck);
            draw(deck, compDeck);
            draw(deck, playerDeck);
            return firstTurn(deck, compDeck, playerDeck);

        } else {
            return false;
        }
    }

    public void shuffle(ArrayList<Card> deck) {
        Collections.shuffle(deck);
    }
}
