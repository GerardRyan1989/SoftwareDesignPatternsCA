/**
 *Represents a dealer of the system
 *@author Gerard Ryan
 */
public class CardDealer extends SystemUser implements Observer{// inheriting from the CardPlayer class

    public CardDealer(){
        setShuffleBehaviour(new Shuffle());
    }


}


