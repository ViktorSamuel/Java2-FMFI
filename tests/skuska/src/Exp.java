import java.util.Collection;
import java.util.Optional;

public class Exp extends Fun {
    public Exp() {
        super("Exp");
    }

    @Override
    public Double eval(Double x) {
        return strategy.calcExp(x);
    }
}
