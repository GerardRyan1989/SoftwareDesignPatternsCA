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
    public void testStrategy(){

        Assert.assertEquals("Gerard Ryan", c1.getName());
        Assert.assertEquals(25, c1.getAge());
        Assert.assertEquals(150.00, c1.getBalance(), 0.0);
        Assert.assertNotSame(c1.shuffleBehaviour.shuffleDeck(), noShuffle.shuffleDeck());

        Assert.assertEquals("John Jones", c2.getName());
        Assert.assertEquals(19, c2.getAge());
        Assert.assertEquals(175.00, c2.getBalance(), 0.0);
        Assert.assertSame(c2.shuffleBehaviour.shuffleDeck(), noShuffle.shuffleDeck());
        Assert.assertNotSame(c2.shuffleBehaviour.shuffleDeck(), shuffle.shuffleDeck());
        
    }
}
