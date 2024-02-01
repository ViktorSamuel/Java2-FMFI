
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
        return x - Math.pow(x, 3) / 6 + Math.pow(x, 5) / 120 - Math.pow(x, 7) / 5040 + Math.pow(x, 9) / 362880;
    }

    @Override
    public Double calcExp(double x) {
        return 1 + x + Math.pow(x, 2) / 2 + Math.pow(x, 3) / 6 + Math.pow(x, 4) / 24 + Math.pow(x, 5) / 120 + Math.pow(x, 6) / 720 + Math.pow(x, 7) / 5040 + Math.pow(x, 8) / 40320 + Math.pow(x, 9) / 362880;
    }
}