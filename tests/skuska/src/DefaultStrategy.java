import java.util.OptionalDouble;
import static java.lang.Math.sin;
import static java.lang.Math.exp;
public class DefaultStrategy implements Strategy {
    private static DefaultStrategy instance;

    private DefaultStrategy() {}

    public static DefaultStrategy getInstance() {
        DefaultStrategy localInstance = instance;
        if (localInstance == null) {
            synchronized (DefaultStrategy.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new DefaultStrategy();
                }
            }
        }
        return localInstance;
    }

    @Override
    public Double calcSin(double x) {
        return sin(x);
    }

    @Override
    public Double calcExp(double x) {
        return exp(x);
    }
}