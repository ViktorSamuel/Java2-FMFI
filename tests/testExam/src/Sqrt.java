import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.Optional;

public class Sqrt extends Function implements Serializable {
    private static volatile Sqrt instance;

    private Sqrt() {
        super("Sqrt");
    }

    public static Sqrt getInstance() {
        if (instance == null) {
            synchronized (Sqrt.class) {
                if (instance == null) {
                    instance = new Sqrt();
                }
            }
        }
        return instance;
    }

    private Object readResolve() throws ObjectStreamException {
        return getInstance();
    }

    @Override
    public Optional<Double> eval(Double input) {
        if (input == null) return Optional.empty();

        double result = Math.sqrt(input);
        if (Double.isInfinite(result) || Double.isNaN(result)) {
            return Optional.empty();
        }
        return Optional.of(result);
    }
}