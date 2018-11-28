public interface WinLoseTemplate{
    SystemUser checkHandsAgainstEachOther(int userValue, int dealerValue, SystemUser cardplayer, SystemUser dealer);
    SystemUser checkSpecialValues(int userValue, int dealerValue, SystemUser cardplayer, SystemUser dealer, Pot pot);
    void returnWinner(SystemUser winner);
}
