import org.junit.*;

public class CommandTest {

    private WinLoseCheck winLoseCheckOne;
    private WinLoseCheck winLoseCheckTwo;
    private WinLoseBlackJack blackJack;
    private WinLoseFortyFive fortyFive;
    private SwitchGameMode switchGameMode;

    @Before
    public void setUp() {
       winLoseCheckOne = new WinLoseBlackJack();
       winLoseCheckTwo = new WinLoseFortyFive();
       switchGameMode = new SwitchGameMode();
       blackJack = new WinLoseBlackJack();
       fortyFive = new WinLoseFortyFive();
    }

    @Test
    public synchronized void commandTest() {

        winLoseCheckOne = switchGameMode.SwitchGame(winLoseCheckOne);
        winLoseCheckTwo = switchGameMode.SwitchGame(winLoseCheckTwo);

        Assert.assertEquals(winLoseCheckOne.getBustValue(), fortyFive.getBustValue());
        Assert.assertNotEquals(winLoseCheckOne.getBustValue(), blackJack.getBustValue());

        Assert.assertEquals(winLoseCheckTwo.getBustValue(), blackJack.getBustValue());
        Assert.assertNotEquals(winLoseCheckTwo.getBustValue(), fortyFive.getBustValue());

    }
}