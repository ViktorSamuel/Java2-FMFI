import java.util.Optional;

public class Sin extends Fun{
    public Sin() {
        super("Sin");
    }
    @Override
    public Double eval(Double x) {
        return strategy.calcSin(x);
    }
}
