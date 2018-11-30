import javax.swing.*;

public abstract class WinLoseCheck implements WinLoseTemplate{

    Pot pot;
    private int bustValue;
    private String gameName;
    private SystemUser winner;

    public final void CheckWinners(int userValue, int dealerValue, CardPlayer cardPlayer, CardDealer cardDealer, Pot pot){
        winner = checkSpecialValues(userValue,dealerValue,cardPlayer,cardDealer, pot);
        if(winner == null){
            winLoseCheck(userValue,dealerValue,cardPlayer,cardDealer,pot);
        }
    }

    public final void winLoseCheck(int userValue, int dealerValue, CardPlayer cardPlayer, CardDealer dealer, Pot pot){
        this.pot = pot;
        boolean isBust = checkIfBust(dealerValue, cardPlayer, dealer, pot);
        if(!isBust){
            returnWinner(checkHandsAgainstEachOther(userValue, dealerValue, cardPlayer,  dealer));
        }

    }

    public SystemUser checkHandsAgainstEachOther(int userValue, int dealerValue, SystemUser cardplayer, SystemUser dealer) {

        SystemUser winner = null;

        if(dealerValue <= this.getBustValue() && dealerValue < userValue)
        {
            winner = cardplayer;
        }

        if(dealerValue > userValue && dealerValue <= 45)
        {
            winner = dealer;
        }

        if(dealerValue == userValue)
        {
            winner = null;
        }

        return winner;
    }

    public void returnWinner(SystemUser winner){
           pot.gameFinished(winner);

           if(winner != null){
               JOptionPane.showMessageDialog(null, winner.getName() + " has won this Hand with");
           }

           if(winner == null){
               JOptionPane.showMessageDialog(null,  " hand has ended in a tie");
           }
    }

    public boolean checkIfBust(int handValue, SystemUser Winner, SystemUser Bust, Pot pot) {
        boolean isBust = false;

        if(handValue > this.getBustValue()){
            JOptionPane.showMessageDialog(null, Bust.getName() + " has Bust\n" + Winner.getName() + " wins this hand") ;
            this.pot = pot;
            this.pot.gameFinished(Winner);
            isBust = true;
        }

        return isBust;
    }

    public void setBustValue(int bustValue){
        this.bustValue = bustValue;
    }

    public int getBustValue(){
        return bustValue;
    }

    public void setGameName(String gameName){
        this.gameName = gameName;
    }

    public String getGameName(){
        return gameName;
    }

}
