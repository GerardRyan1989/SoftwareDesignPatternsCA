import javax.swing.*;
import java.util.*;

public abstract class CardStore {

    abstract ArrayList<PlayingCard> createCards();

    public ArrayList<PlayingCard> getCards(){

        ArrayList<PlayingCard> cards = createCards();

        return cards;
    }
}
