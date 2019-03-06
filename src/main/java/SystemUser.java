import java.io.*;

public abstract class SystemUser implements Serializable{

    private int age;
    private String name;
    private double balance;
    ShuffleBehaviour shuffleBehaviour;

    public SystemUser(){
        this("Unknown",0,0.0);
    }

    public SystemUser(String name , double balance){
        this.balance = balance;
        this.name = name;
    }

    public SystemUser(String uName, int age, double balance){
        this.name = uName;
        this.age = age;
        this.balance = balance;
    }

    public void setName(String uName){
        this.name = uName;
    }

    public void setAge(int age){
        this.age = age;
    }

    public void setBalance(double balance){
        this.balance = balance;
    }

    public void updateBalance(double updateAmount){
        this.balance += updateAmount;
    }

    public String getName(){

        return name;
    }

    public int getAge(){
        return age;
    }

    protected double getBalance(){
        return balance;
    }

    public String toString(){
        return name + " " + age + " €" + String.format("%.2f",balance);
    }

    public void setShuffleBehaviour(ShuffleBehaviour sb){
        this.shuffleBehaviour = sb;
    }

    public void update(SystemUser winner,  double stake) {

        if (this.getClass() == winner.getClass()) {
            this.updateBalance(stake);
        }

        if (this.getClass() != winner.getClass()) {
            this.updateBalance(-stake);
        }
    }
}
