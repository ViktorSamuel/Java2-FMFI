package observer;

public class Client {
    public static void main(String[] args) {
        Market market = new Market();

        ExchangeRateObserver bull = new BullObserver();
        ExchangeRateObserver bear = new BearObserver();

        market.addObserver(bull);
        market.addObserver(bear);

        market.setState(4.6);
        market.setState(-4.4);
    }
}
