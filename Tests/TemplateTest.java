import org.junit.*;

public class TemplateTest {

    private CardPlayer player;
    private CardDealer dealer;
    private Pot pot;
    private int playerValue;
    private int dealerValue;
    private WinLoseCheck winLose;
    @Before
    public void setUp(){
        player = new CardPlayer();
        dealer = new CardDealer();
        player.setBalance(5000);
        dealer.setBalance(5000);
        pot = new Pot();
        pot.setStake(500);
        playerValue = 35;
        dealerValue = 40;
        pot.registerObserver(player);
        pot.registerObserver(dealer);
        winLose = new WinLoseFortyFive();
    }

    @Test
    public void TemplateTest(){

        winLose.CheckWinners(playerValue, dealerValue, player, dealer, pot);

        Assert.assertTrue(player.getBalance() == 5500);
        Assert.assertTrue(dealer.getBalance() == 4500);


        playerValue = 36;
        dealerValue = 40;
        winLose.CheckWinners(playerValue, dealerValue, player, dealer, pot);

        Assert.assertTrue(player.getBalance() == 5000);
        Assert.assertTrue(dealer.getBalance() == 5000);

        winLose = new WinLoseBlackJack();

        playerValue = 21;
        dealerValue = 20;
        winLose.CheckWinners(playerValue, dealerValue, player, dealer, pot);

        Assert.assertTrue(player.getBalance() == 5500);
        Assert.assertTrue(dealer.getBalance() == 4500);


        playerValue = 16;
        dealerValue = 35;
        winLose.CheckWinners(playerValue, dealerValue, player, dealer, pot);

        Assert.assertTrue(player.getBalance() == 6000);
        Assert.assertTrue(dealer.getBalance() == 4000);
    }

}
