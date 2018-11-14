/**
 *Represents a dealer of the system
 *@author Gerard Ryan
 */
public class CardDealer extends SystemUser implements Observer{// inheriting from the CardPlayer class

    public CardDealer(){
        setShuffleBehaviour(new Shuffle());
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


