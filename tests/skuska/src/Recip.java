import java.util.Optional;

public class Recip extends Fun {
    public Recip() {
        super("Recip");
    }
    @Override
    public Double eval(Double x) {
        return 1 / (x * x + 1);
    }
}
