package observer;

public class BearObserver implements ExchangeRateObserver {
    @Override
    public void update(double rate) {
        if (rate < 0) {
            System.out.println("Bears are happy! The exchange rate is falling.");
        } else {
            System.out.println("Bears are not happy. The exchange rate is not falling.");
        }
    }
}