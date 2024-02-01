import java.util.Optional;

public abstract class Fun {
    protected Strategy strategy;
    private String name;

    public Fun(String name) {
        this.name = name;
    }

    public void SetStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
    public String getName() {
        return name;
    }
    public abstract Double eval(Double x);
}
