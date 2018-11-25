import javax.swing.*;

public abstract class PlayingCard {
	
	protected String name;
	protected String suit;
	protected int value;
	protected ImageIcon cardImage;

	public PlayingCard(){

	}

	public PlayingCard(String name, String suit, int value, ImageIcon cardImage){
		
		this.name = name;
		this.suit = suit;
		this.value = value;
		this.cardImage = cardImage;
		
	}// constructor method to set card all card values
	
	public String getName(){
		return name;
	}//returns the card name

	public void setSuit(String suit){
		this.suit = suit;
	}

	public String getSuit(){
		return suit;
	}

	public int getValue(){
		return value;
	}// returns an int value of  the card value
		
	public String getImage(){
		return cardImage.toString();
	} // returns a string representation of an image icon
	
	public String toString(){
		return name + " " + suit + " " + value + " " + cardImage;
	}	//returns a string representationn of a card
}