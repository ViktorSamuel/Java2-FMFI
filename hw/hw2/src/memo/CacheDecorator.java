package memo;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

class CacheDecorator extends Decorator {
    private final Map<BigInteger, BigInteger> cache = new HashMap<>();

    public CacheDecorator(Function decoratedFunction) {
        super(decoratedFunction);
    }

    @Override
    public BigInteger eval(BigInteger i) {
        if (cache.containsKey(i)) {
            return cache.get(i);
        } else {
            BigInteger result = super.eval(i);
            cache.put(i, result);
            return result;
        }
    }
}
