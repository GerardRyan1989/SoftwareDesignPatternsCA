public class Shuffle implements ShuffleBehaviour{

    public PlayingCard[] shuffleDeck(){
        Deck deck = Deck.getDeck();
        PlayingCard[] shuffled = new PlayingCard[52];
        PlayingCard[] newDeck =  deck.createDeck();
        boolean [] check = new boolean[52];
        for(int i = 0; i < 52; i++)
        {
            int random = (int)(Math.random()*52);
            while(check[random])
            {
                random = (int)(Math.random()*52);
            }

            check[random] = true;
            shuffled[i] = newDeck[random];
        }

        return shuffled;
    }
}
