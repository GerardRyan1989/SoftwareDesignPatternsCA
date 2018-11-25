/**
*Represents a card player  of the system
*@author Gerard Ryan
*/
public class CardPlayer extends SystemUser implements Observer{

    public CardPlayer(){
        setShuffleBehaviour(new NoShuffle());
    }

}

