package sat.tests;

import org.junit.Test;
import sat.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;
public class AndTest {

    @Test
    public void testEvalTrue() {
        ArrayList<Term> trueTerms = new ArrayList<>();
        trueTerms.add(new Konstanta(true));
        trueTerms.add(new Premenna("x"));
        trueTerms.add((new Konstanta(false).negate()));

        And and = new And(trueTerms);

        Map<String, Boolean> values = new HashMap<>();
        values.put("x", true);

        assertTrue(and.Eval(values));
    }

    @Test
    public void testEvalFalse() {
        ArrayList<Term> falseTerms = new ArrayList<>();
        falseTerms.add(new Konstanta(true));
        falseTerms.add((new Premenna("x").negate()));
        falseTerms.add(new Konstanta(true));

        And and = new And(falseTerms);

        Map<String, Boolean> values = new HashMap<>();
        values.put("x", true);

        assertFalse(and.Eval(values));
    }

    @Test
    public void testNegate() {
        ArrayList<Term> terms = new ArrayList<>();
        terms.add(new Konstanta(true));
        terms.add(new Premenna("x"));
        terms.add(((new Konstanta(true).negate())));

        And and = new And(terms);
        Term negatedTerm = and.negate();

        assertTrue(negatedTerm instanceof Or);
    }

    @Test
    public void testGetVariables() {
        ArrayList<Term> terms = new ArrayList<>();
        terms.add(new Konstanta(true));
        terms.add(new Premenna("x"));
        terms.add((new Konstanta(true)).negate());

        And and = new And(terms);
        ArrayList<String> variables = and.getVariables();

        assertEquals(1, variables.size());
        assertTrue(variables.contains("x"));
    }

    @Test
    public void testIsSatisfiable() {
        ArrayList<Term> terms = new ArrayList<>();
        terms.add(new Konstanta(true));
        terms.add(new Premenna("x"));
        terms.add(new Premenna("y"));

        And and = new And(terms);
        assertTrue(and.isSatisfiable());
    }

    @Test
    public void testToString() {
        ArrayList<Term> terms = new ArrayList<>();
        terms.add(new Konstanta(true));
        terms.add(new Premenna("x"));
        terms.add((new Konstanta(true)).negate());

        And and = new And(terms);

        assertEquals("(true AND x AND false)", and.toString());
    }
}
