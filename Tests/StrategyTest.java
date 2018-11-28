import org.junit.*;

public class StrategyTest {

    private CardPlayer c1;
    private CardPlayer c2;
    private Shuffle shuffle;
    private NoShuffle noShuffle;

    @Before
    public void setUp(){
        c1 = new CardPlayer();
        c1.setAge(25);
        c1.setName("Gerard Ryan");
        c1.setBalance(150.00);
        shuffle = new Shuffle();
        c1.setShuffleBehaviour(shuffle);

        c2 = new CardPlayer();
        c2.setAge(19);
        c2.setName("John Jones");
        c2.setBalance(175.00);
        noShuffle = new NoShuffle();
        c2.setShuffleBehaviour(noShuffle);
    }

    @Test
    public void StrategyTest(){

        Assert.assertTrue(c1.getName().equals("Gerard Ryan"));
        Assert.assertTrue(c1.getAge() == 25);
        Assert.assertTrue(c1.getBalance() == 150.00);
        Assert.assertFalse(c1.shuffleBehaviour.shuffleDeck() == noShuffle.shuffleDeck());

        Assert.assertTrue(c2.getName().equals("John Jones"));
        Assert.assertTrue(c2.getAge() == 19);
        Assert.assertTrue(c2.getBalance() == 175.00);
        Assert.assertTrue(c2.shuffleBehaviour.shuffleDeck() == noShuffle.shuffleDeck());
        Assert.assertFalse(c2.shuffleBehaviour.shuffleDeck() == shuffle.shuffleDeck());

    }
}
