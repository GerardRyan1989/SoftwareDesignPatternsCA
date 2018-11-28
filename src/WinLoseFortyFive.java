import javax.swing.*;

public class WinLoseFortyFive extends WinLoseCheck {

    private SystemUser winner;
    public WinLoseFortyFive(){
        this.setGameName("Forty Five");
        this.setBustValue(45);
    }



    @Override
    public SystemUser checkSpecialValues(int userValue, int dealerValue, SystemUser cardPlayer, SystemUser dealer, Pot pot ) {
        this.pot = pot;
        winner = null;

        if (userValue == 35 && dealerValue != 35 ) {
            winner = cardPlayer;
        }

        if (dealerValue == 35 && userValue != 35 ) {
            winner = dealer;
        }

        if(winner != null){
            returnWinner(winner);
        }

        return winner;

    }

}
