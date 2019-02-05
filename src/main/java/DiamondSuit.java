import javax.swing.*;
import java.util.ArrayList;

public class DiamondSuit extends CardSuit {

    private ArrayList<PlayingCard> diamonds;
    private DiamondPlayingCard card;

    @Override
    void createCards() {
        diamonds = new ArrayList();

        for(int i = 0; i < getNUmOfCardsPerSuit(); i++){

            switch(i){
                case 0:
                    card = new DiamondPlayingCard(1,"Ace", new ImageIcon("cards/AceDiamond.jpg"));
                    break;
                case 1:
                    card = new DiamondPlayingCard(2,"Two", new ImageIcon("cards/TwoDiamond.jpg"));
                    break;
                case 2:
                    card = new DiamondPlayingCard(3,"Three", new ImageIcon("cards/ThreeDiamond.jpg"));
                    break;
                case 3:
                    card = new DiamondPlayingCard(4,"Four", new ImageIcon("cards/FourDiamond.jpg"));
                    break;
                case 4:
                    card = new DiamondPlayingCard(5,"Five", new ImageIcon("cards/FiveDiamond.jpg"));
                    break;
                case 5:
                    card = new DiamondPlayingCard(6,"Six", new ImageIcon("cards/SixDiamond.jpg"));
                    break;
                case 6:
                    card = new DiamondPlayingCard(7,"Seven", new ImageIcon("cards/SevenDiamond.jpg"));
                    break;
                case 7:
                    card = new DiamondPlayingCard(8,"Eight", new ImageIcon("cards/EightDiamond.jpg"));
                    break;
                case 8:
                    card = new DiamondPlayingCard(9,"Nine", new ImageIcon("cards/NineDiamond.jpg"));
                    break;
                case 9:
                    card = new DiamondPlayingCard(10,"Ten", new ImageIcon("cards/TenDiamond.jpg"));
                    break;
                case 10:
                    card = new DiamondPlayingCard(10,"Jack", new ImageIcon("cards/JackDiamond.jpg"));
                    break;
                case 11:
                    card = new DiamondPlayingCard(10,"Queen", new ImageIcon("cards/QueenDiamond.jpg"));
                    break;
                case 12:
                    card = new DiamondPlayingCard(10,"King", new ImageIcon("cards/KingDiamond.jpg"));
                    break;
            }

            diamonds.add(card);
        }

        this.cards = diamonds;
    }
}
