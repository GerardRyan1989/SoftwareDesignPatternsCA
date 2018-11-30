import org.junit.*;

public class SingletonTest {


    private Deck deckOne;
    private Deck deckTwo;

    @Before
    public void setUp(){
        deckOne = Deck.getDeck();
        deckTwo =  Deck.getDeck();
    }

    @Test
    public void testSingleton() {

        Assert.assertEquals(1, Deck.getNumberofInstances());
        Assert.assertFalse(Deck.getNumberofInstances() > 1);

    }
}
