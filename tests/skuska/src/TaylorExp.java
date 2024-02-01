import java.util.Optional;
import static java.lang.Math.pow;
public class TaylorExp implements Strategy {
    private static volatile TaylorExp instance;
    private String name;

    private TaylorExp() {
        this.name = "TaylorExp";
    }

    public static TaylorExp getInstance() {
        TaylorExp localInstance = instance;
        if (localInstance == null) {
            synchronized (TaylorExp.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new TaylorExp();
                }
            }
        }
        return localInstance;
    }

    @Override
    public Optional<Double> eval(Double x) {
        return Optional.of(1 + x + pow(x, 2) / 2 + pow(x, 3) / 6 + pow(x, 4) / 24 + pow(x, 5) / 120 + pow(x, 6) / 720 + pow(x, 7) / 5040 + pow(x, 8) / 40320 + pow(x, 9) / 362880);
    }
}
