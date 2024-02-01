import java.util.Optional;
import static java.lang.Math.pow;
public class TaylorSin implements Strategy {
    private static volatile TaylorSin instance;
    private String name;

    private TaylorSin() {
        this.name = "TaylorSin";
    }

    public static TaylorSin getInstance() {
        TaylorSin localInstance = instance;
        if (localInstance == null) {
            synchronized (TaylorSin.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new TaylorSin();
                }
            }
        }
        return localInstance;
    }

    @Override
    public Optional<Double> eval(Double x) {
        return Optional.of(x - pow(x, 3) / 6 + pow(x, 5) / 120 - pow(x, 7) / 5040 + pow(x, 9) / 362880);
    }
}
