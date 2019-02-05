import java.util.*;

public abstract class CardSuit {

    private final int NUM_OF_CARDS_PER_SUIT = 13;
    ArrayList<PlayingCard> cards = new ArrayList();
    abstract void createCards();

    ArrayList<PlayingCard> getCards(){

        return cards;
    }

    public  int getNUmOfCardsPerSuit(){
        return NUM_OF_CARDS_PER_SUIT;
    }
}
