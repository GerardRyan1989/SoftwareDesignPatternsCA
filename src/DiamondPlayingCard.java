import javax.swing.*;

public class DiamondPlayingCard extends PlayingCard{

    public DiamondPlayingCard(int value, String name, ImageIcon cardImage){
        this.suit = "Diamond";
        this.value = value;
        this.name = name;
        this.cardImage = cardImage;
    }

}
