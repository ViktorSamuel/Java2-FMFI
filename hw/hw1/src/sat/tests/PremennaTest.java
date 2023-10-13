package sat.tests;

import org.junit.Test;
import sat.Premenna;
import sat.Term;
import sat.Negacia;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;
public class PremennaTest {

    @Test
    public void testEvalMappedVariable() {
        Map<String, Boolean> values = new HashMap<>();
        values.put("x", true);
        values.put("y", false);

        Premenna premennaX = new Premenna("x");
        Premenna premennaY = new Premenna("y");

        assertTrue(premennaX.Eval(values));
        assertFalse(premennaY.Eval(values));
    }

    @Test
    public void testEvalUnmappedVariable() {
        Map<String, Boolean> values = new HashMap<>();
        values.put("x", true);

        Premenna premennaY = new Premenna("y");

        assertFalse(premennaY.Eval(values));
    }

    @Test
    public void testNegate() {
        Premenna premennaX = new Premenna("x");

        Term negatedTerm = premennaX.negate();

        assertTrue(negatedTerm instanceof Negacia);
        assertEquals("!" + premennaX.toString(), ((Negacia) negatedTerm).toString());
    }

    @Test
    public void testGetVariables() {
        Premenna premennaX = new Premenna("x");
        Premenna premennaY = new Premenna("y");

        ArrayList<String> variablesX = premennaX.getVariables();
        ArrayList<String> variablesY = premennaY.getVariables();

        assertEquals(1, variablesX.size());
        assertEquals(1, variablesY.size());
        assertTrue(variablesX.contains("x"));
        assertTrue(variablesY.contains("y"));
    }

    @Test
    public void testIsSatisfiable() {
        Premenna premennaX = new Premenna("x");
        Premenna premennaY = new Premenna("y");

        assertTrue(premennaX.isSatisfiable());
        assertTrue(premennaY.isSatisfiable());
    }

    @Test
    public void testToString() {
        Premenna premennaX = new Premenna("x");
        Premenna premennaY = new Premenna("y");

        assertEquals("x", premennaX.toString());
        assertEquals("y", premennaY.toString());
    }
}
