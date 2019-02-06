import javax.swing.*;

public class HeartPlayingCard extends PlayingCard{

    public HeartPlayingCard(int value, String name, ImageIcon cardImage){
        this.suit = "Heart";
        this.value = value;
        this.name = name;
        this.cardImage = cardImage;
    }
}
