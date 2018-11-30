import javax.swing.*;
import java.util.ArrayList;

public class ClubSuit extends CardSuit {


    private ArrayList<PlayingCard> clubs;
    private ClubPlayingCard card;


    @Override
    void createCards() {
        clubs = new ArrayList<>();

        for(int i = 0; i < getNUmOfCardsPerSuit() ; i++){

            switch(i){
                case 0:
                    card = new ClubPlayingCard(1,"Ace", new ImageIcon("cards/AceClub.jpg"));
                    break;
                case 1:
                    card = new ClubPlayingCard(2,"Two", new ImageIcon("cards/TwoClub.jpg"));
                    break;
                case 2:
                    card = new ClubPlayingCard(3,"Three", new ImageIcon("cards/ThreeClub.jpg"));
                    break;
                case 3:
                    card = new ClubPlayingCard(4,"Four", new ImageIcon("cards/FourClub.jpg"));
                    break;
                case 4:
                    card = new ClubPlayingCard(5,"Five", new ImageIcon("cards/FiveClub.jpg"));
                    break;
                case 5:
                    card = new ClubPlayingCard(6,"Six", new ImageIcon("cards/SixClub.jpg"));
                    break;
                case 6:
                    card = new ClubPlayingCard(7,"Seven", new ImageIcon("cards/SevenClub.jpg"));
                    break;
                case 7:
                    card = new ClubPlayingCard(8,"Eight", new ImageIcon("cards/EightClub.jpg"));
                    break;
                case 8:
                    card = new ClubPlayingCard(9,"Nine", new ImageIcon("cards/NineClub.jpg"));
                    break;
                case 9:
                    card = new ClubPlayingCard(10,"Ten", new ImageIcon("cards/TenClub.jpg"));
                    break;
                case 10:
                    card = new ClubPlayingCard(10,"Jack", new ImageIcon("cards/JackClub.jpg"));
                    break;
                case 11:
                    card = new ClubPlayingCard(10,"Queen", new ImageIcon("cards/QueenClub.jpg"));
                    break;
                case 12:
                    card = new ClubPlayingCard(10,"King", new ImageIcon("cards/KingClub.jpg"));
                    break;
            }//end of switch statement

            clubs.add(card);
        }

        this.cards = clubs;
    }
}
