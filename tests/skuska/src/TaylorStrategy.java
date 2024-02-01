import static java.lang.Math.pow;
public class TaylorStrategy implements Strategy {
    private static TaylorStrategy instance;

    private TaylorStrategy() {}

    public static TaylorStrategy getInstance() {
        TaylorStrategy localInstance = instance;
        if (localInstance == null) {
            synchronized (TaylorStrategy.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new TaylorStrategy();
                }
            }
        }
        return localInstance;
    }

    @Override
    public Double calcSin(double x) {
        return x - pow(x, 3) / 6 + pow(x, 5) / 120 - pow(x, 7) / 5040 + pow(x, 9) / 362880;
    }

    @Override
    public Double calcExp(double x) {
        return 1 + x + pow(x, 2) / 2 + pow(x, 3) / 6 + pow(x, 4) / 24 + pow(x, 5) / 120 + pow(x, 6) / 720 + pow(x, 7) / 5040 + pow(x, 8) / 40320 + pow(x, 9) / 362880;
    }
}