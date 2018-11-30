import javax.swing.*;

public class WinLoseFortyFive extends WinLoseCheck {

    private SystemUser winner;
    private final int WIN_LOSE_SPECIAL_VALUE = 35;
    public WinLoseFortyFive(){
        this.setGameName("Forty Five");
        this.setBustValue(45);
    }

    @Override
    public SystemUser checkSpecialValues(int userValue, int dealerValue, SystemUser cardPlayer, SystemUser dealer, Pot pot ) {
        this.pot = pot;
        winner = null;

        if (userValue == WIN_LOSE_SPECIAL_VALUE  && dealerValue != WIN_LOSE_SPECIAL_VALUE  ) {
            winner = cardPlayer;
        }

        if (dealerValue == WIN_LOSE_SPECIAL_VALUE && userValue != WIN_LOSE_SPECIAL_VALUE  ) {
            winner = dealer;
        }

        if(winner != null){
            returnWinner(winner);
        }

        return winner;

    }

}
