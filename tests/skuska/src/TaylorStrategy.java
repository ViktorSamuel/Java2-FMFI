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
        double result = 0;
        double a = x, b = 1;
        for(int i = 1; i < 10; i+=2){
            result += a/b;
            a *= -x * x;
            b *= i * (i + 1);
        }
        return result;
//        return x - pow(x, 3) / 6 + pow(x, 5) / 120 - pow(x, 7) / 5040 + pow(x, 9) / 362880;
    }

    @Override
    public Double calcExp(double x) {
        double result = 1;
        double a = x, b = 1;
        for(int i = 1; i < 10; i++){
            result +=  a/b;
            a *= x;
            b *= i;
        }
        return result;
//        return 1 + x + pow(x, 2) / 2 + pow(x, 3) / 6 + pow(x, 4) / 24 + pow(x, 5) / 120 + pow(x, 6) / 720 + pow(x, 7) / 5040 + pow(x, 8) / 40320 + pow(x, 9) / 362880;
    }
}