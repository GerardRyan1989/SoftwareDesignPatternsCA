public class SwitchGameMode {

    private WinLoseBlackJack winLoseBlackJack = new WinLoseBlackJack();
    private WinLoseFortyFive winLoseFortyFive = new WinLoseFortyFive();

    public WinLoseCheck SwitchGame(WinLoseCheck winLoseCheck){


        if(winLoseCheck.getBustValue() == winLoseBlackJack.getBustValue()){
            SetGameAsFortyFiveCommand fourtyFive = new SetGameAsFortyFiveCommand();

            winLoseCheck = fourtyFive.execute();
        }
        else if(winLoseCheck.getBustValue() == winLoseFortyFive.getBustValue()){
            SetGameAsBlackJackCommand blackJack = new SetGameAsBlackJackCommand();

             winLoseCheck = blackJack.execute();
        }

        return winLoseCheck;
    }

}
