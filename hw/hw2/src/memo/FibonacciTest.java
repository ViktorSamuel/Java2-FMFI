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

    @Test
    public void testFibonacci20th() {
        Function fibonacciFunction = new FibonacciFunction();
        Function fibonacciFunctionWithCache = new CacheDecorator(fibonacciFunction);
        assertEquals(BigInteger.valueOf(6765), fibonacciFunctionWithCache.eval(BigInteger.valueOf(20)));
    }

    @Test
    public void testFibonacci30th() {
        Function fibonacciFunction = new FibonacciFunction();
        Function fibonacciFunctionWithCache = new CacheDecorator(fibonacciFunction);
        assertEquals(BigInteger.valueOf(832040), fibonacciFunctionWithCache.eval(BigInteger.valueOf(30)));
    }
}
