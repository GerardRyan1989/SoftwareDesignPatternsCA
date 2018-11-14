/**
*Represents a card player  of the system
*@author Gerard Ryan
*/
public class CardPlayer extends SystemUser implements Observer{

    public CardPlayer(){
        setShuffleBehaviour(new NoShuffle());
    }

    public void update(SystemUser winner,  double stake) {

        if(this.getClass() == winner.getClass()){
            this.updateBalance(stake);
        }

        if(this.getClass() != winner.getClass()){
            this.updateBalance(-stake);
        }
    }
}

