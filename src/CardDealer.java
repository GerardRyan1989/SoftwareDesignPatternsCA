public class CardDealer extends SystemUser {// inheriting from the CardPlayer class

    public CardDealer(){
        setShuffleBehaviour(new Shuffle());
    }

}
