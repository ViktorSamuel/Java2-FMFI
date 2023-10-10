package sat.tests;

import org.junit.Test;
import sat.Konstanta;
import sat.Term;

import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.*;

public class KonstantaTest {

    @Test
    public void testEvalTrue() {
        Konstanta konstantaTrue = new Konstanta(true);
        Map<String, Boolean> values = new HashMap<>();
        assertTrue(konstantaTrue.Eval(values));
    }

    @Test
    public void testEvalFalse() {
        Konstanta konstantaFalse = new Konstanta(false);
        Map<String, Boolean> values = new HashMap<>();
        assertFalse(konstantaFalse.Eval(values));
    }

    @Test
    public void testNegateTrue() {
        Konstanta konstantaTrue = new Konstanta(true);
        Term negated = konstantaTrue.negate();
        assertFalse(negated.Eval(new HashMap<>()));
    }

    @Test
    public void testNegateFalse() {
        Konstanta konstantaFalse = new Konstanta(false);
        Term negated = konstantaFalse.negate();
        assertTrue(negated.Eval(new HashMap<>()));
    }

    @Test
    public void testGetVariables() {
        Konstanta konstantaTrue = new Konstanta(true);
        assertTrue(konstantaTrue.getVariables().isEmpty());
    }

    @Test
    public void testIsSatisfiable() {
        Konstanta konstantaTrue = new Konstanta(true);
        assertTrue(konstantaTrue.isSatisfiable());
    }

    @Test
    public void testToStringTrue() {
        Konstanta konstantaTrue = new Konstanta(true);
        assertEquals("true", konstantaTrue.toString());
    }

    @Test
    public void testToStringFalse() {
        Konstanta konstantaFalse = new Konstanta(false);
        assertEquals("false", konstantaFalse.toString());
    }
}
