package sat.tests;

import org.junit.Test;
import sat.Implikacia;
import sat.Premenna;
import sat.Term;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.*;

public class ImplikaciaTest {

    @Test
    public void testEvalTrueIfLeftFalseRightTrue() {
        Term left = new Premenna("var1", false);
        Term right = new Premenna("var2", true);
        Implikacia implikacia = new Implikacia(left, right);
        Map<String, Boolean> values = new HashMap<>();
        assertTrue(implikacia.Eval(values));
    }

    @Test
    public void testEvalTrueIfLeftTrueRightTrue() {
        Term left = new Premenna("var1", true);
        Term right = new Premenna("var2", true);
        Implikacia implikacia = new Implikacia(left, right);
        Map<String, Boolean> values = new HashMap<>();
        assertTrue(implikacia.Eval(values));
    }

    @Test
    public void testEvalFalseIfLeftTrueRightFalse() {
        Term left = new Premenna("var1", true);
        Term right = new Premenna("var2", false);
        Implikacia implikacia = new Implikacia(left, right);
        Map<String, Boolean> values = new HashMap<>();
        assertFalse(implikacia.Eval(values));
    }

    @Test
    public void testNegate() {
        Term left = new Premenna("var1", true);
        Term right = new Premenna("var2", false);
        Implikacia implikacia = new Implikacia(left, right);
        Term negated = implikacia.negate();
        assertTrue(negated.Eval(new HashMap<>()));
    }

    @Test
    public void testGetVariables() {
        Term left = new Premenna("var1", true);
        Term right = new Premenna("var2", false);
        Implikacia implikacia = new Implikacia(left, right);
        ArrayList<String> variables = implikacia.getVariables();
        assertEquals(2, variables.size());
        assertTrue(variables.contains("var1"));
        assertTrue(variables.contains("var2"));
    }

    @Test
    public void testIsSatisfiableBothSatisfiable() {
        Term left = new Premenna("var1", true);
        Term right = new Premenna("var2", false);
        Implikacia implikacia = new Implikacia(left, right);
        assertFalse(implikacia.isSatisfiable());
    }

    @Test
    public void testIsSatisfiableRightUnsatisfiable() {
        Term left = new Premenna("var1", false);
        Term right = new Premenna("var2", false);
        Implikacia implikacia = new Implikacia(left, right);
        assertFalse(implikacia.isSatisfiable());
    }

    @Test
    public void testToString() {
        Term left = new Premenna("var1", true);
        Term right = new Premenna("var2", false);
        Implikacia implikacia = new Implikacia(left, right);
        assertEquals("(var1 -> var2)", implikacia.toString());
    }
}
