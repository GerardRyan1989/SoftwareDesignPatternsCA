import javax.swing.*;
import java.util.*;

public abstract class CardStore {

    ArrayList<PlayingCard> cards = new ArrayList<>();
    abstract void createCards();

    ArrayList<PlayingCard> getCards(){

        return cards;
    }
}
