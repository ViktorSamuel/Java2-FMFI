package memo;

import java.math.BigInteger;

public class Decorator implements Function{
    private final Function function;

    public Decorator(Function function) {
        this.function = function;
    }

    @Override
    public BigInteger eval(BigInteger i) {
        return function.eval(i);
    }
}
