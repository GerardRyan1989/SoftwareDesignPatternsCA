import javax.swing.*;
import java.util.ArrayList;

public class HeartCardStore extends CardStore {
    private ArrayList<PlayingCard> hearts;
    private HeartPlayingCard card;

    @Override
    void createCards() {
        hearts = new ArrayList<>();

        for(int i = 0; i < getNUmOfCardsPerSuit() ; i++){

            switch(i){
                case 0:
                    card = new HeartPlayingCard(1,"Ace", new ImageIcon("cards/AceHeart.jpg"));
                    break;
                case 1:
                    card = new HeartPlayingCard(2,"Two", new ImageIcon("cards/TwoHeart.jpg"));
                    break;
                case 2:
                    card = new HeartPlayingCard(3,"Three", new ImageIcon("cards/ThreeHeart.jpg"));
                    break;
                case 3:
                    card = new HeartPlayingCard(4,"Four", new ImageIcon("cards/FourHeart.jpg"));
                    break;
                case 4:
                    card = new HeartPlayingCard(5,"Five", new ImageIcon("cards/FiveHeart.jpg"));
                    break;
                case 5:
                    card = new HeartPlayingCard(6,"Six", new ImageIcon("cards/SixHeart.jpg"));
                    break;
                case 6:
                    card = new HeartPlayingCard(7,"Seven", new ImageIcon("cards/SevenHeart.jpg"));
                    break;
                case 7:
                    card = new HeartPlayingCard(8,"Eight", new ImageIcon("cards/EightHeart.jpg"));
                    break;
                case 8:
                    card = new HeartPlayingCard(9,"Nine", new ImageIcon("cards/NineHeart.jpg"));
                    break;
                case 9:
                    card = new HeartPlayingCard(10,"Ten", new ImageIcon("cards/TenHeart.jpg"));
                    break;
                case 10:
                    card = new HeartPlayingCard(10,"Jack", new ImageIcon("cards/JackHeart.jpg"));
                    break;
                case 11:
                    card = new HeartPlayingCard(10,"Queen", new ImageIcon("cards/QueenHeart.jpg"));
                    break;
                case 12:
                    card = new HeartPlayingCard(10,"King", new ImageIcon("cards/KingHeart.jpg"));
                    break;
            }

            hearts.add(card);
        }

        this.cards = hearts;
    }
}
