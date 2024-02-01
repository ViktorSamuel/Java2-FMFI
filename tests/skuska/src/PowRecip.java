import java.util.Optional;
import static java.lang.Math.pow;
public class PowRecip implements Strategy {
    private static volatile PowRecip instance;
    private String name;

    private PowRecip() {
        this.name = "PowRecip";
    }

    public static PowRecip getInstance() {
        PowRecip localInstance = instance;
        if (localInstance == null) {
            synchronized (PowRecip.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new PowRecip();
                }
            }
        }
        return localInstance;
    }

    @Override
    public Optional<Double> eval(Double x) {
        return Optional.of(1 / (pow(x, 2)-1));
    }
}
