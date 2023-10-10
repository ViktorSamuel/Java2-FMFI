package sat.tests;

import sat.And;
import sat.Premenna;
import sat.Term;
import org.junit.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.*;

public class AndTest {

    @Test
    public void testEvalAllTrue() {
        ArrayList<Term> terms = new ArrayList<>();
        terms.add(new Premenna("var1", true));
        terms.add(new Premenna("var2", true));
        terms.add(new Premenna("var3", true));
        And and = new And(terms);
        Map<String, Boolean> values = new HashMap<>();
        assertTrue(and.Eval(values));
    }

    @Test
    public void testEvalOneFalse() {
        ArrayList<Term> terms = new ArrayList<>();
        terms.add(new Premenna("var1", true));
        terms.add(new Premenna("var2", false));
        terms.add(new Premenna("var3", true));
        And and = new And(terms);
        Map<String, Boolean> values = new HashMap<>();
        assertFalse(and.Eval(values));
    }

    @Test
    public void testNegate() {
        ArrayList<Term> terms = new ArrayList<>();
        terms.add(new Premenna("var1", true));
        terms.add(new Premenna("var2", false));
        terms.add(new Premenna("var3", false));
        And and = new And(terms);
        Term negated = and.negate();
        assertTrue(negated.Eval(new HashMap<>()));
    }

    @Test
    public void testGetVariables() {
        ArrayList<Term> terms = new ArrayList<>();
        terms.add(new Premenna("var1", true));
        terms.add(new Premenna("var2", false));
        terms.add(new Premenna("var3", true));
        And and = new And(terms);
        ArrayList<String> variables = and.getVariables();
        assertEquals(3, variables.size());
        assertTrue(variables.contains("var1"));
        assertTrue(variables.contains("var2"));
        assertTrue(variables.contains("var3"));
    }

    @Test
    public void testIsSatisfiableAllSatisfiable() {
        ArrayList<Term> terms = new ArrayList<>();
        terms.add(new Premenna("var1", true));
        terms.add(new Premenna("var2", true));
        terms.add(new Premenna("var3", true));
        And and = new And(terms);
        assertTrue(and.isSatisfiable());
    }

    @Test
    public void testIsSatisfiableOneUnsatisfiable() {
        ArrayList<Term> terms = new ArrayList<>();
        terms.add(new Premenna("var1", true));
        terms.add(new Premenna("var2", false));
        terms.add(new Premenna("var3", true));
        And and = new And(terms);
        assertFalse(and.isSatisfiable());
    }

    @Test
    public void testToString() {
        ArrayList<Term> terms = new ArrayList<>();
        terms.add(new Premenna("var1", true));
        terms.add(new Premenna("var2", true));
        terms.add(new Premenna("var3", false));
        And and = new And(terms);
        assertEquals("(var1 AND var2 AND var3)", and.toString());
    }
}
