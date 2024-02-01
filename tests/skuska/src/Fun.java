
public abstract class Fun {
    protected Strategy strategy;

    public Fun(Strategy strategy) {
        this.strategy = strategy;
    }

    public abstract Double eval(Double x);
}
