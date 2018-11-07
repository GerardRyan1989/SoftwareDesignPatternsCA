import javax.swing.*;

public class Card{
	
	private String name;
	private String suit;
	private int value;
	private ImageIcon cardImage;
	private String hello;
	
	public Card(String name, String suit,int value,ImageIcon cardImage){
		
		this.name = name;
		this.suit = suit;
		this.value = value;
		this.cardImage = cardImage;
		
	}// constructor method to set card all card values
	
	public String getName(){
		return name;
	}//returns the card name
	
	public String getSuit(){
		return suit;
	}// returns the suit values of the card
	
	public int getValue(){
		return value;
	}// returns an int value of  the card value
		
	public String getImage(){
		return cardImage.toString();
	} // returns a string representation of an imageicon
	
	public String toString(){
		return name + " " + suit + " " + value + " " + cardImage;
	}	//returns a string representationn of a card
}