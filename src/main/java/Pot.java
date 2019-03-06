import java.util.*;

public class Pot implements Subject{


    private double potSize;
    private double stake;
    private SystemUser winner;
    private ArrayList observers = new ArrayList();


    public void Pot(){

    }

    public void registerObserver(Observer o){
           observers.add(o);
    }

    public void removeObserver(Observer o){
        int i = observers.indexOf(o);
        if (i >= 0) {
            observers.remove(i);
        }
    }

    public void updateObservers(){
        if(this.winner != null){
            for (int i = 0; i < observers.size(); i++) {
                Observer observer = (Observer) observers.get(i);
                observer.update(winner, stake);
            }
        }

    }

    public void setPotValues(double stake){
        this.stake = stake;
        this.potSize = (stake * 2);
    }

    public void gameFinished(SystemUser winner){
        this.winner = winner;
        updateObservers();
    }

    public void setStake(double stake){
        this.stake = stake;
    }

    public double getStake(){
        return stake;
    }

}
