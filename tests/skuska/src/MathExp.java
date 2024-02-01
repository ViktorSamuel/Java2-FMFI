import java.util.Optional;
import static java.lang.Math.exp;
public class MathExp implements Strategy {
    private static volatile MathExp instance;
    private String name;

    private MathExp() {
        this.name = "MathExp";
    }

    public static MathExp getInstance() {
        MathExp localInstance = instance;
        if (localInstance == null) {
            synchronized (MathExp.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new MathExp();
                }
            }
        }
        return localInstance;
    }

    @Override
    public Optional<Double> eval(Double x) {
        return Optional.of(exp(x));
    }
}
