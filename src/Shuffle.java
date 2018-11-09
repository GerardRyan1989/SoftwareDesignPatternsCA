public class Shuffle implements ShuffleBehaviour{

    public Card [] shuffleDeck(){
        Deck deck = new Deck();
        Card[] shuffled = new Card[52];
        Card[] newDeck =  deck.createDeck();
        boolean [] check = new boolean[52];                             //this populates the shuffled deck in a random order with out any cards repeating
        for(int i = 0; i < 52; i++)										//it uses a boolean array of the same size as shuffled array which set to false
        {															//it generates a random number from 1 to 52 and if this element of the array matching the random number
            int random = (int)(Math.random()*52);					//is set to true it will loop till it generates a random number where the matching element of the boolean array is
            while(check[random])									//false and it will then store the element of deck matching the random number in the shuffled array
            {
                random = (int)(Math.random()*52);
            }

            check[random] = true;
            shuffled[i] = newDeck[random];
        }//end of loop


        return shuffled;

    }// end of shuffled deck method
}
