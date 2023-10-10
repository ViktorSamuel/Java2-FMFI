package sat.tests;

import org.junit.Test;
import sat.Or;
import sat.Premenna;
import sat.Term;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.*;

public class OrTest {

    @Test
    public void testEvalAllFalse() {
        ArrayList<Term> terms = new ArrayList<>();
        terms.add(new Premenna("var1", false));
        terms.add(new Premenna("var2", false));
        terms.add(new Premenna("var3", false));
        Or or = new Or(terms);
        Map<String, Boolean> values = new HashMap<>();
        assertFalse(or.Eval(values));
    }

    @Test
    public void testEvalOneTrue() {
        ArrayList<Term> terms = new ArrayList<>();
        terms.add(new Premenna("var1", false));
        terms.add(new Premenna("var2", true));
        terms.add(new Premenna("var3", false));
        Or or = new Or(terms);
        Map<String, Boolean> values = new HashMap<>();
        assertTrue(or.Eval(values));
    }

    @Test
    public void testNegate() {
        ArrayList<Term> terms = new ArrayList<>();
        terms.add(new Premenna("var1", false));
        terms.add(new Premenna("var2", true));
        terms.add(new Premenna("var3", false));
        Or or = new Or(terms);
        Term negated = or.negate();
        assertFalse(negated.Eval(new HashMap<>()));
    }

    @Test
    public void testGetVariables() {
        ArrayList<Term> terms = new ArrayList<>();
        terms.add(new Premenna("var1", false));
        terms.add(new Premenna("var2", true));
        terms.add(new Premenna("var3", false));
        Or or = new Or(terms);
        ArrayList<String> variables = or.getVariables();
        assertEquals(3, variables.size());
        assertTrue(variables.contains("var1"));
        assertTrue(variables.contains("var2"));
        assertTrue(variables.contains("var3"));
    }

    @Test
    public void testIsSatisfiableAllUnsatisfiable() {
        ArrayList<Term> terms = new ArrayList<>();
        terms.add(new Premenna("var1", false));
        terms.add(new Premenna("var2", false));
        terms.add(new Premenna("var3", false));
        Or or = new Or(terms);
        assertFalse(or.isSatisfiable());
    }

    @Test
    public void testIsSatisfiableOneSatisfiable() {
        ArrayList<Term> terms = new ArrayList<>();
        terms.add(new Premenna("var1", false));
        terms.add(new Premenna("var2", true));
        terms.add(new Premenna("var3", false));
        Or or = new Or(terms);
        assertTrue(or.isSatisfiable());
    }

    @Test
    public void testToString() {
        ArrayList<Term> terms = new ArrayList<>();
        terms.add(new Premenna("var1", true));
        terms.add(new Premenna("var2", true));
        terms.add(new Premenna("var3", false));
        Or or = new Or(terms);
        assertEquals("(var1 OR var2 OR var3)", or.toString());
    }
}
