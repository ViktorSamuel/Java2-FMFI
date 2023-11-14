package Strategy;

public class Context {
    private Strategy strategy;

    public Context(Strategy strategy){
        this.strategy = strategy;
    }

    public void executeStrategy(){
        strategy.execute();
    }

    public void setStrategy(Strategy strategy){
        this.strategy = strategy;
    }
}
