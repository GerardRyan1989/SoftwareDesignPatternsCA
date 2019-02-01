import javax.swing.*;
import java.util.*;

public class SpadeSuit extends CardSuit {

    private ArrayList<PlayingCard> spades;
    private SpadePlayingCard card;
    @Override
    void  createCards() {
        spades = new ArrayList<>();

        for(int i = 0; i < getNUmOfCardsPerSuit(); i++){

            switch(i){
                case 0:
                    card = new SpadePlayingCard(1,"Ace", new ImageIcon("cards/AceSpade.jpg"));
                    break;
                case 1:
                    card = new SpadePlayingCard(2,"Two", new ImageIcon("cards/TwoSpade.jpg"));
                    break;
                case 2:
                    card = new SpadePlayingCard(3,"Three", new ImageIcon("cards/ThreeSpade.jpg"));
                    break;
                case 3:
                    card = new SpadePlayingCard(4,"Four", new ImageIcon("cards/FourSpade.jpg"));
                    break;
                case 4:
                    card = new SpadePlayingCard(5,"Five", new ImageIcon("cards/FiveSpade.jpg"));
                    break;
                case 5:
                    card = new SpadePlayingCard(6,"Six", new ImageIcon("cards/SixSpade.jpg"));
                    break;
                case 6:
                    card = new SpadePlayingCard(7,"Seven", new ImageIcon("cards/SevenSpade.jpg"));
                    break;
                case 7:
                    card = new SpadePlayingCard(8,"Eight", new ImageIcon("cards/EightSpade.jpg"));
                    break;
                case 8:
                    card = new SpadePlayingCard(9,"Nine", new ImageIcon("cards/NineSpade.jpg"));
                    break;
                case 9:
                    card = new SpadePlayingCard(10,"Ten", new ImageIcon("cards/TenSpade.jpg"));
                    break;
                case 10:
                    card = new SpadePlayingCard(10,"Jack", new ImageIcon("cards/JackSpade.jpg"));
                    break;
                case 11:
                    card = new SpadePlayingCard(10,"Queen", new ImageIcon("cards/QueenSpade.jpg"));
                    break;
                case 12:
                    card = new SpadePlayingCard(10,"King", new ImageIcon("cards/KingSpade.jpg"));
                    break;
                    //test for team City
            }

            spades.add(card);
        }

        this.cards = spades;
    }
}
