import javax.swing.*;

public abstract class PlayingCard {
	
	protected String name;
	protected String suit;
	protected int value;
	protected ImageIcon cardImage;

	public PlayingCard(){ }

	public PlayingCard(String name, String suit, int value, ImageIcon cardImage){
		
		this.name = name;
		this.suit = suit;
		this.value = value;
		this.cardImage = cardImage;
		
	}
	
	public String getName(){
		return name;
	}

	public String getSuit(){
		return suit;
	}

	public int getValue(){
		return value;
	}
		
	public String getImage(){
		return cardImage.toString();
	}
	
	public String toString(){
		return name + " " + suit + " " + value + " " + cardImage;
	}
}