import org.junit.*;
import java.util.ArrayList;


public class FactoryMethodTest {

    private DiamondSuit diamonds;
    private ClubSuit clubs;
    private SpadeSuit spades;
    private HeartSuit hearts;
    private ArrayList<PlayingCard> clubsList;
    private ArrayList<PlayingCard> spadesList;
    private ArrayList<PlayingCard> diamondsList;
    private ArrayList<PlayingCard> heartsList;
    private final int NUMOFCARDSINASUITE = 13;

    @Before
    private void setUp() {

            clubsList = new ArrayList();
            spadesList = new ArrayList();
            heartsList = new ArrayList();
            diamondsList = new ArrayList();

            diamonds = new DiamondSuit();
            clubs = new ClubSuit();
            spades = new SpadeSuit();
            hearts = new HeartSuit();

            diamonds.createCards();
            clubs.createCards();
            spades.createCards();
            hearts.createCards();

            heartsList.addAll(hearts.getCards());
            clubsList.addAll(clubs.getCards());
            spadesList.addAll(spades.getCards());
            diamondsList.addAll(diamonds.getCards());
    }

    @Test
    public synchronized void factoryMethodTest() {


        for(int i = 0; i < NUMOFCARDSINASUITE; i++){


            Assert.assertEquals("Heart", heartsList.get(i).getSuit());
            Assert.assertEquals("Club", clubsList.get(i).getSuit());
            Assert.assertEquals("Spade", spadesList.get(i).getSuit());
            Assert.assertEquals("Diamond", diamondsList.get(i).getSuit());

        }

        Assert.assertEquals(heartsList.size(), NUMOFCARDSINASUITE);
        Assert.assertEquals(spadesList.size(), NUMOFCARDSINASUITE);
        Assert.assertEquals(diamondsList.size(), NUMOFCARDSINASUITE);
        Assert.assertEquals(clubsList.size(), NUMOFCARDSINASUITE);

    }
}
