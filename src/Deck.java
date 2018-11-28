import java.util.ArrayList;


public class Deck{

    private PlayingCard[] deck = new PlayingCard[52];
	private DiamondCardStore diamonds;
	private ClubCardStore clubs;
	private SpadeCardStore spades;
	private HeartCardStore hearts;
	private ArrayList<PlayingCard> allSuits;
	private static Deck uniqueDeck;
	private static int numberOfInstances = 0;

	private Deck(){ }

	public synchronized static Deck getDeck(){
		if(uniqueDeck == null){
			uniqueDeck = new Deck();
			numberOfInstances++;
		}

		return uniqueDeck;
	}

	public PlayingCard[] createDeck(){

		allSuits = new ArrayList<>();
		clubs = new ClubCardStore();
		hearts = new HeartCardStore();
		spades = new SpadeCardStore();
		diamonds  =new DiamondCardStore();

		clubs.createCards();
		hearts.createCards();
		spades.createCards();
		diamonds.createCards();

		allSuits.addAll(clubs.getCards());
		allSuits.addAll(hearts.getCards());
		allSuits.addAll(spades.getCards());
		allSuits.addAll(diamonds.getCards());

		for(int i = 0; i < 52; i++){

			deck[i] = allSuits.get(i);
		}

		return deck;
	}



	public static int getNumberofInstances(){
		return numberOfInstances;
	}
}
