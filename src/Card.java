/*
Rohit Singh
111056206
CSE 114
Project
 */
public class Card {

    private String color;
    private int number;

    public Card() {

    }

    public Card(String color, int number) {
        this.color = color;
        this.number = number;
    }

    public String getColor() {
        return color;
    }

    public int getNumber() {
        return number;
    }

    public String toString() {
        return number + " " + color;
    }

    public boolean equals(Object o) {
        Card i = (Card) o;
        if (i.getNumber() == number || i.getColor().equals(color)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Card card = new Card("Blue", 5);
        System.out.print(card.color + " " + card.number);
    }
}
