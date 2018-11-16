import javax.swing.*;


public class Deck{

	private String suit="";       // card Suit
	private String name="";       // card Name
	//private int value =0, num =0; // value is int value of card,// num is increment each time in for loop and reaches a value of 51, this is used to get an imageIcon
    private PlayingCard[] deck = new PlayingCard[52];// an  array to hold 52 cards in the order of 1 to 52
	private static Deck uniqueDeck;

	private Deck(){ }

	public synchronized static Deck getDeck(){
		if(uniqueDeck == null){
			uniqueDeck = new Deck();
		}
		return uniqueDeck;
	}

	public PlayingCard[] createDeck(){
		int num = 0;
		int value = 0;

		for(int j =0; j < 4; j++){

			switch(j){
				case 0: suit = "Clubs";         // the outer loop run 4 times and changes suit on each loop
						break;                  // the inner loop runs 13 times for every time the outer loop runs once creating 52 cards in total
					                           // the cards get their values from the switch statement in each loop for example if the outer loop
				case 1: suit = "Diamonds";     // was 3 and the inner loop 7 the card  would have the following values
						break;                 // suit : Hearts, Name: Five, Value: 5
						
				case 2: suit = "Hearts";
						break;
						
				case 3: suit = "Spades";
						break;
			}//end of switch statement
				
			
			for(int i = 0; i < 13; i++){

		 	switch(i){
		 		case 0: name = "Ace";
		 				value = 1;
		 				break;
		 		case 1: name = "Two";
		 			    value = 2;
		 				break;
		 		case 2: name = "Three";
		 			    value = 3;
		 				break;
		 		case 3: name = "Four";
		 			    value = 4;
		 				break;	
		 		case 4: name = "Five";
		 		        value = 5;
		 				break;
		 		case 5: name = "Six";
		 			    value = 6;
		 				break;
		 		case 6: name = "Seven";
		 		        value = 7;
		 				break;
		 		case 7: name = "Eight";
		 		        value = 8;
		 				break;
		 		case 8: name = "Nine";
		 		        value = 9;
		 				break;
		 		case 9: name = "Ten";
		 		        value = 10;
		 				break;
		 		case 10: name = "Jack";
		 		         value = 10;
		 				break;
		 		case 11: name = "Queen";
		 		         value = 10;
		 				break;
		 		case 12: name = "King";
		 		         value = 10;
		 				break;
		 	}//end of switch statement
		 	deck[num] = new PlayingCard(name,suit,value,new ImageIcon("cards/"+(num+1)+".jpg"));//populating the array with cards
		 	
		 	num++;//incrementing num so array will reach 52
		 	
			}//end of the inner nested loop
		}//end of the outer loop
		return deck;
	}
}//end of main

