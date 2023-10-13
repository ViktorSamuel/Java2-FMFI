package sat.tests;

import org.junit.Test;
import sat.Konstanta;
import sat.Term;

import static org.junit.Assert.*;

public class KonstantaTest {

    @Test
    public void testEval() {
        Konstanta konstantaTrue = new Konstanta(true);
        Konstanta konstantaFalse = new Konstanta(false);

        assertTrue(konstantaTrue.Eval(null));
        assertFalse(konstantaFalse.Eval(null));
    }

    @Test
    public void testNegateTrue() {
        Konstanta konstantaTrue = new Konstanta(true);
        Konstanta konstantaFalse = new Konstanta(false);

        Term trueNegated = konstantaTrue.negate();
        Term falseNegated = konstantaFalse.negate();

        assertFalse(trueNegated.Eval(null));
        assertTrue(falseNegated.Eval(null));
    }

    @Test
    public void testGetVariables() {
        Konstanta konstantaTrue = new Konstanta(true);
        Konstanta konstantaFalse = new Konstanta(false);

        assertTrue(konstantaTrue.getVariables().isEmpty());
        assertTrue(konstantaFalse.getVariables().isEmpty());
    }

    @Test
    public void testIsSatisfiable() {
        Konstanta konstantaTrue = new Konstanta(true);
        Konstanta konstantaFalse = new Konstanta(false);

        assertTrue(konstantaTrue.isSatisfiable());
        assertFalse(konstantaFalse.isSatisfiable());
    }

    @Test
    public void testToStringTrue() {
        Konstanta konstantaTrue = new Konstanta(true);
        Konstanta konstantaFalse = new Konstanta(false);

        assertEquals("true", konstantaTrue.toString());
        assertEquals("false", konstantaFalse.toString());
    }
}
