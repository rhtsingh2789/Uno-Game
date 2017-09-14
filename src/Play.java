
/*
Rohit Singh
111056206
CSE 114
Project
 */
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Play extends Deck {

    public void compPlay(ArrayList<Card> deck, ArrayList<Card> compDeck, ArrayList<Card> discard, int count) {

        for (int i = 0; i < compDeck.size() - 1; i++) {
            if (compDeck.get(i).equals(discard.get(discard.size() - 1))) {
                discard.add(compDeck.get(i));
                compDeck.remove(i);
                return;
            }
        }

        if (deck.size() < 1) {
            for (Card e : discard) {
                deck.add(e);
            }
            shuffle(deck);
        }
        if (count < 1) {
            draw(deck, compDeck);
            compPlay(deck, compDeck, discard, ++count);
            count++;
        } else {
            return;
        }

    }

    public void playerPlay(ArrayList<Card> deck, ArrayList<Card> playerDeck, ArrayList<Card> discard, int tries) {
        Scanner input = new Scanner(System.in);
        if (deck.size() < 1) {
            for (Card e : discard) {
                deck.add(e);
            }
            shuffle(deck);
        }
        System.out.println("Your Choices:");
        int count = 0;
        for (Card e : playerDeck) {
            System.out.println(count++ + ": " + e);
        }

        int choice = input.nextInt();

        if (tries == 0 && choice == -1) {

            playerDeck.add(deck.get(0));
            deck.remove(0);
            playerPlay(deck, playerDeck, discard, ++tries);
        } else if (choice == -1 && tries == 1) {
            return;
        } else {
            if (playerDeck.get(choice).equals(discard.get(discard.size() - 1))) {
                discard.add(playerDeck.get(choice));
                deck.remove(deck.size() - 1);
                playerDeck.remove(choice);
            }
        }

    }

}
