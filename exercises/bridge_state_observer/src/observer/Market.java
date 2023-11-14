package observer;

import java.util.ArrayList;
import java.util.List;

public class Market {
    private List<ExchangeRateObserver> observers = new ArrayList<>();
    private double rate;
    public void addObserver(ExchangeRateObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(ExchangeRateObserver observer) {
        observers.remove(observer);
    }
    public void notifyObservers() {
        for (ExchangeRateObserver observer : observers) {
            observer.update(rate);
        }
    }
    public void setState(double rate) {
        this.rate = rate;
        notifyObservers();
    }
}