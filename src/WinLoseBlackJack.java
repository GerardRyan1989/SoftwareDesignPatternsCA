import javax.swing.*;

public class WinLoseBlackJack extends WinLoseCheck{

    public WinLoseBlackJack() {
       this.setGameName("BlackJack");
       this.setBustValue(21);
    }


    @Override
    public SystemUser checkSpecialValues(int userValue, int dealerValue, SystemUser cardplayer, SystemUser dealer, Pot pot) {
        //do nothing
        return null;
    }

}

