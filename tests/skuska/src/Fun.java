import java.util.Optional;

public abstract class Fun {
    protected Strategy strategy;
    public Fun(Strategy strategy) {
        this.strategy = strategy;
    }

    public Optional<Double> eval(Double x) {
        return strategy.eval(x);
    }
}
