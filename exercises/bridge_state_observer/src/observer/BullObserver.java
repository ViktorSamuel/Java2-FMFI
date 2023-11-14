package observer;

class BullObserver implements ExchangeRateObserver {
    @Override
    public void update(double rate) {
        if (rate > 0) {
            System.out.println("Bulls are happy! The exchange rate is rising.");
        } else {
            System.out.println("Bulls are not happy. The exchange rate is not rising.");
        }
    }
}