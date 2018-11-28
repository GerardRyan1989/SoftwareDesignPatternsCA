import org.junit.*;

import java.util.ArrayList;

public class FactoryMethodTest {

    private DiamondCardStore diamonds;
    private ClubCardStore clubs;
    private SpadeCardStore spades;
    private HeartCardStore hearts;
    private ArrayList<PlayingCard> clubsList;
    private ArrayList<PlayingCard> spadesList;
    private ArrayList<PlayingCard> diamondsList;
    private ArrayList<PlayingCard> heartsList;
    private int numOfCardsInASuite;

    @Before
    public void setUp() {
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

            numOfCardsInASuite = 13;
    }

    @Test
    public synchronized void factoryMethodTest() {


        for(int i = 0; i < 13; i++){


              Assert.assertTrue(heartsList.get(i).getSuit().equals("Heart"));
              Assert.assertTrue(clubsList.get(i).getSuit().equals("Club"));
              Assert.assertTrue(spadesList.get(i).getSuit().equals("Spade"));
              Assert.assertTrue(diamondsList.get(i).getSuit().equals("Diamond"));

        }

        Assert.assertTrue(heartsList.size() == numOfCardsInASuite);
        Assert.assertTrue(spadesList.size() == numOfCardsInASuite);
        Assert.assertTrue(diamondsList.size() == numOfCardsInASuite);
        Assert.assertTrue(clubsList.size() == numOfCardsInASuite);




    }
}
