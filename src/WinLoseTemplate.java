public interface WinLoseTemplate{
    SystemUser checkHandsAgainstEachOther(int userValue, int dealerValue, SystemUser cardplayer, SystemUser dealer);
    void returnWinner(SystemUser winner);
}
