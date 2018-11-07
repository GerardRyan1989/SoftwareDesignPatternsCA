public class Dealer extends User{// inheriting from the User class
    private String name;     //Dealers name
    private double balance;  //Dealers balance

    public Dealer(){
         this("Dealers", 0.0);
    }//no argument constructer that gives default values to name and balance, these values are "Dealers" and 0.0

    public Dealer( String name ,double balance){
        this.balance = balance;
        this.name = name;
    }//2 argument coonstructor sets dealer name and balance to values passed into constructor

    public String toString(){
        return "name: " +name + "Balance: €" + String.format("%.2f, balance");
    }//returns a string representation of the dealers name and balance

}
