

public class Exp extends Fun {
    public Exp(Strategy strategy) {
        super(strategy);
    }

    @Override
    public Double eval(Double x) {
        return strategy.calcExp(x);
    }
}
