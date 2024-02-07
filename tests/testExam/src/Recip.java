import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.Optional;

public class Recip extends Function implements Serializable {
    private static volatile Recip instance;

    private Recip() {
        super("Recip");
    }

    public static Recip getInstance() {
        if (instance == null) {
            synchronized (Sin.class) {
                if (instance == null) {
                    instance = new Recip();
                }
            }
        }
        return instance;
    }

    private Object readResolve() throws ObjectStreamException {
        return getInstance();
    }

    @Override
    public Optional<Double> eval(Double x) {
        if (x == null) return Optional.empty();
        double result = 1.0 / x;
        if (Double.isInfinite(result) || Double.isNaN(result)) {
            return Optional.empty();
        }
        return Optional.of(result);
    }
}