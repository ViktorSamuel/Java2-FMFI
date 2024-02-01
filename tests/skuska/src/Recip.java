

public class Recip extends Fun {
    public Recip(Strategy strategy) {
        super(strategy);
    }
    @Override
    public Double eval(Double x) {
        return 1 / (x * x + 1);
    }
}
