import java.util.ArrayList;


public class Deck{

    private PlayingCard[] deck = new PlayingCard[52];
	private DiamondCardStore diamonds;
	private ClubCardStore clubs;
	private SpadeCardStore spades;
	private HeartCardStore hearts;
	private ArrayList<PlayingCard> allSuits;
	private static Deck uniqueDeck;

	private Deck(){ }

	public synchronized static Deck getDeck(){
		if(uniqueDeck == null){
			uniqueDeck = new Deck();
		}
		return uniqueDeck;
	}

	public PlayingCard[] createDeck(){

		allSuits = new ArrayList<>();
		clubs = new ClubCardStore();
		hearts = new HeartCardStore();
		spades = new SpadeCardStore();
		diamonds  =new DiamondCardStore();


		allSuits.addAll(clubs.createCards());
		allSuits.addAll(hearts.createCards());
		allSuits.addAll(spades.createCards());
		allSuits.addAll(diamonds.createCards());

		for(int i = 0; i < 52; i++){

			deck[i] = allSuits.get(i);
		}

		return deck;
	}
}
