import java.util.Optional;
import static java.lang.Math.sin;
public class MathSin implements Strategy {
    private static volatile MathSin instance;
    private String name;

    private MathSin() {
        this.name = "MathSin";
    }

    public static MathSin getInstance() {
        MathSin localInstance = instance;
        if (localInstance == null) {
            synchronized (MathSin.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new MathSin();
                }
            }
        }
        return localInstance;
    }

    @Override
    public Optional<Double> eval(Double x) {
        return Optional.of(sin(x));
    }
}
