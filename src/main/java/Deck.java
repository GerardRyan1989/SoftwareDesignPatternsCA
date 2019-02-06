import java.util.ArrayList;


public class Deck{

    private PlayingCard[] deck = new PlayingCard[52];
	private DiamondSuit diamonds;
	private ClubSuit clubs;
	private SpadeSuit spades;
	private HeartSuit hearts;
	private ArrayList<PlayingCard> allSuits;
	private static Deck uniqueDeck;
	private static int numberOfInstances = 0;
	private final int DeckSize = 52;

	private Deck(){ }

	public static Deck getDeck(){
		if(uniqueDeck == null){
			uniqueDeck = new Deck();
			numberOfInstances++;
		}

		return uniqueDeck;
	}

	public PlayingCard[] createDeck(){

		allSuits = new ArrayList();
		clubs = new ClubSuit();
		hearts = new HeartSuit();
		spades = new SpadeSuit();
		diamonds  =new DiamondSuit();

		clubs.createCards();
		hearts.createCards();
		spades.createCards();
		diamonds.createCards();

		allSuits.addAll(clubs.getCards());
		allSuits.addAll(hearts.getCards());
		allSuits.addAll(spades.getCards());
		allSuits.addAll(diamonds.getCards());

		for(int i = 0; i < DeckSize ; i++){

			deck[i] = allSuits.get(i);
		}

		return deck;
	}



	public static int getNumberofInstances(){
		return numberOfInstances;
	}
}
