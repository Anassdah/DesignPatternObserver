package FirstSolution;

import java.util.ArrayList;
import java.util.List;

public class Subject implements Runnable {

    private List<Observer> observers = new ArrayList<Observer>();
    private int state;

    public Subject(int val) {
        this.setState(val);
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }

    public void subscribe(Observer observer){
        observers.add(observer);
    }

    public void unsubscribe(Observer observer){
        observers.remove(observer);
    }

    public void notifyAllObservers(){
        for (Observer observer : observers) {
            observer.update();
        }
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                this.setState((this.getState() + 1) % 60);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
        }
    }


}