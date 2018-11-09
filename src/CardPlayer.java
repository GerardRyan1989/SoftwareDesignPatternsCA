/**
*Represents a user of the system
*@author Gerard Ryan
*/
public class CardPlayer extends SystemUser {

    public CardPlayer(){
        setShuffleBehaviour(new NoShuffle());
    }
}