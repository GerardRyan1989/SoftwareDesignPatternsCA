public class SetGameAsFortyFiveCommand implements Command{

    private WinLoseCheck winLoseCheck;

    public SetGameAsFortyFiveCommand(){

    }

    public WinLoseCheck execute(){
        winLoseCheck = new WinLoseFortyFive();

        return winLoseCheck;
    }

}
