package memo;

import java.math.BigInteger;

public class FibonacciFunction implements Function{
    @Override
    public BigInteger eval(BigInteger i) {
        if (i.equals(BigInteger.ZERO)) {
            return BigInteger.ZERO;
        } else if (i.equals(BigInteger.ONE)) {
            return BigInteger.ONE;
        } else {
            return eval(i.subtract(BigInteger.ONE)).add(eval(i.subtract(BigInteger.TWO)));
        }
    }
}
