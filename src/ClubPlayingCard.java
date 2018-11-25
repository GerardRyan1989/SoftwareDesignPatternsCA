import javax.swing.*;

public class ClubPlayingCard extends PlayingCard {

    public ClubPlayingCard(int value, String name, ImageIcon cardImage){
        this.suit = "Club";
        this.value = value;
        this.name = name;
        this.cardImage = cardImage;
    }


}
