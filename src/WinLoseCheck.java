import javax.swing.*;

public abstract class WinLoseCheck implements WinLoseTemplate{

    Pot pot;
    private int bustValue;
    private boolean isBust;
    public final void winLoseCheck(int userValue, int dealerValue, CardPlayer cardPlayer, CardDealer dealer, Pot pot){
        this.pot = pot;
        isBust = checkIfBust(dealerValue, cardPlayer, dealer, pot);
        if(isBust == false){
            returnWinner(checkHandsAgainstEachOther(userValue, dealerValue, cardPlayer,  dealer));
        }

    }

    public void returnWinner(SystemUser winner){
           pot.gameFinished(winner);

           if(winner != null){
               JOptionPane.showMessageDialog(null, winner.getName() + "has won this Hand with");
           }

           if(winner == null){
               JOptionPane.showMessageDialog(null,  "hand has ended in a tie");
           }
    }

    public abstract boolean checkIfBust(int handValue, SystemUser Winner, SystemUser Bust, Pot pot);

    public void setBustValue(int bustValue){
        this.bustValue = bustValue;
    }

    public int getBustValue(){
        return bustValue;
    }

}
