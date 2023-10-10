package sat.tests;

import org.junit.Test;
import sat.Premenna;
import sat.Term;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.*;

public class PremennaTest {

    @Test
    public void testEvalTrue() {
        Premenna premennaTrue = new Premenna("testVar", true);
        Map<String, Boolean> values = new HashMap<>();
        values.put("testVar", true);
        assertTrue(premennaTrue.Eval(values));
    }

    @Test
    public void testEvalFalse() {
        Premenna premennaFalse = new Premenna("testVar", false);
        Map<String, Boolean> values = new HashMap<>();
        values.put("testVar", false);
        assertFalse(premennaFalse.Eval(values));
    }

    @Test
    public void testNegateTrue() {
        Premenna premennaTrue = new Premenna("testVar", true);
        Term negated = premennaTrue.negate();
        assertFalse(negated.Eval(new HashMap<>()));
    }

    @Test
    public void testNegateFalse() {
        Premenna premennaFalse = new Premenna("testVar", false);
        Term negated = premennaFalse.negate();
        assertTrue(negated.Eval(new HashMap<>()));
    }

    @Test
    public void testGetVariables() {
        Premenna premenna = new Premenna("testVar", true);
        ArrayList<String> variables = premenna.getVariables();
        assertEquals(1, variables.size());
        assertEquals("testVar", variables.get(0));
    }

    @Test
    public void testIsSatisfiable() {
        Premenna premenna = new Premenna("testVar", true);
        assertTrue(premenna.isSatisfiable());
    }

    @Test
    public void testToStringTrue() {
        Premenna premenna = new Premenna("testVar", true);
        assertEquals("testVar", premenna.toString());
    }

    @Test
    public void testToStringFalse() {
        Premenna premenna = new Premenna("testVar", false);
        assertEquals("testVar", premenna.toString());
    }
}
