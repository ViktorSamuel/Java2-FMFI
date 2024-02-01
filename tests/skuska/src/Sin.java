
public class Sin extends Fun{
    public Sin(Strategy strategy) {
        super(strategy);
    }
    @Override
    public Double eval(Double x) {
        return strategy.calcSin(x);
    }
}
