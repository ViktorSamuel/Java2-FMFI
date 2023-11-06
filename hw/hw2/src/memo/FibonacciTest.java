package memo;

import org.junit.*;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;

public class FibonacciTest {
    @Test
    public void testFibonacci10th() {
        Function fibonacciFunction = new FibonacciFunction();
        Function fibonacciFunctionWithCache = new CacheDecorator(fibonacciFunction);
        assertEquals(BigInteger.valueOf(55), fibonacciFunctionWithCache.eval(BigInteger.TEN));
    }
}
