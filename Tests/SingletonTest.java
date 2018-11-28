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
    public void SingletonTest() {

        Assert.assertTrue(Deck.getNumberofInstances() == 1);
        Assert.assertFalse(Deck.getNumberofInstances() > 1);

    }
}
