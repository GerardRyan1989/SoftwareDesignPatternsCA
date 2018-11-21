public class SwitchGameMode {

    private WinLoseBlackJack winLoseBlackJack = new WinLoseBlackJack();
    private WinLoseFortyFive winLoseFortyFive = new WinLoseFortyFive();
    private SetGameAsFortyFiveCommand fourtyFive;
    private SetGameAsBlackJackCommand blackJack;

    public WinLoseCheck SwitchGame(WinLoseCheck winLoseCheck){


        if(winLoseCheck.getBustValue() == winLoseBlackJack.getBustValue()){
            fourtyFive =  new SetGameAsFortyFiveCommand();

            winLoseCheck = fourtyFive.execute();
        }
        else if(winLoseCheck.getBustValue() == winLoseFortyFive.getBustValue()){
             blackJack = new SetGameAsBlackJackCommand();

             winLoseCheck = blackJack.execute();
        }

        return winLoseCheck;
    }

}
