public class SetGameAsBlackJackCommand implements Command{

    private WinLoseCheck winLosecheck;

    public SetGameAsBlackJackCommand(){
    }

    public WinLoseCheck execute(){
        winLosecheck = new WinLoseBlackJack();

        return winLosecheck;
    }
}
