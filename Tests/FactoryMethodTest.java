import org.junit.*;

import java.util.ArrayList;

@SuppressWarnings("Duplicates")
public class FactoryMethodTest {

    private DiamondCardStore diamonds;
    private ClubCardStore clubs;
    private SpadeCardStore spades;
    private HeartCardStore hearts;
    private ArrayList<PlayingCard> clubsList;
    private ArrayList<PlayingCard> spadesList;
    private ArrayList<PlayingCard> diamondsList;
    private ArrayList<PlayingCard> heartsList;
    private final int NUMOFCARDSINASUITE = 13;

    @Before
    private void setUp() {

            clubsList = new ArrayList<>();
            spadesList = new ArrayList<>();
            heartsList = new ArrayList<>();
            diamondsList = new ArrayList<>();

            diamonds = new DiamondCardStore();
            clubs = new ClubCardStore();
            spades = new SpadeCardStore();
            hearts = new HeartCardStore();

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


        for(int i = 0; i < 13; i++){


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
