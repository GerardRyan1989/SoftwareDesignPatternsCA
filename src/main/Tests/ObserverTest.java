import org.junit.*;

public class ObserverTest {


    private CardPlayer c1;
    private CardDealer c2;
    private Pot pot;

    @Before
    public void setUp(){
        pot = new Pot();

        c1 = new CardPlayer();
        c1.setAge(25);
        c1.setName("Gerard Ryan");
        c1.setBalance(150.00);

        c2 = new CardDealer();
        c2.setAge(19);
        c2.setName("John Jones");
        c2.setBalance(175.00);


        pot.registerObserver(c1);
        pot.registerObserver(c2);
        pot.setStake(75.00);

    }

    @Test
    public synchronized void testObserver(){
        pot.gameFinished(c1);


        Assert.assertEquals(225.00, c1.getBalance(), 0.0);
        Assert.assertEquals(100.00, c2.getBalance(), 0.0);

        pot.gameFinished(c2);
        pot.gameFinished(c2);


        Assert.assertEquals(75.00, c1.getBalance(), 0.0);
        Assert.assertEquals(250.00, c2.getBalance(), 0.0);


    }

}
