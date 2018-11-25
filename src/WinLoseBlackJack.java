import javax.swing.*;

public class WinLoseBlackJack extends WinLoseCheck{

    public WinLoseBlackJack() {
       this.setGameName("BlackJack");
       this.setBustValue(21);
    }
    @Override
    public SystemUser checkHandsAgainstEachOther(int userValue, int dealerValue, SystemUser cardplayer, SystemUser dealer) {

        SystemUser winner = null;

        if(dealerValue <= this.getBustValue() && dealerValue < userValue)
        {
            winner = cardplayer;
        }

        if(dealerValue > userValue && dealerValue <= 21)
        {
            winner = dealer;
        }

        if(dealerValue == userValue)
        {
            winner = null;
        }

        return winner;
    }

    @Override
    public  boolean checkIfBust(int handValue, SystemUser Winner, SystemUser Bust, Pot pot) {
        boolean isBust = false;

        if(handValue > this.getBustValue()){
            JOptionPane.showMessageDialog(null, Bust.getName() + " has Bust\n" + Winner.getName() + " wins this hand") ;
            this.pot = pot;
            this.pot.gameFinished(Winner);
            isBust = true;
        }

        return isBust;
        }
}

