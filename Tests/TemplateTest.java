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
    public void testTemplate(){

        winLose.CheckWinners(playerValue, dealerValue, player, dealer, pot);

        Assert.assertEquals(5500, player.getBalance(), 0.0);
        Assert.assertEquals(4500, dealer.getBalance(), 0.0);


        playerValue = 36;
        dealerValue = 40;
        winLose.CheckWinners(playerValue, dealerValue, player, dealer, pot);

        Assert.assertEquals(5000, player.getBalance(), 0.0);
        Assert.assertEquals(5000, dealer.getBalance(), 0.0);

        winLose = new WinLoseBlackJack();

        playerValue = 21;
        dealerValue = 20;
        winLose.CheckWinners(playerValue, dealerValue, player, dealer, pot);

        Assert.assertEquals(5500, player.getBalance(), 0.0);
        Assert.assertEquals(4500, dealer.getBalance(), 0.0);


        playerValue = 16;
        dealerValue = 35;
        winLose.CheckWinners(playerValue, dealerValue, player, dealer, pot);

        Assert.assertEquals(6000, player.getBalance(), 0.0);
        Assert.assertEquals(4000, dealer.getBalance(), 0.0);
    }

}
