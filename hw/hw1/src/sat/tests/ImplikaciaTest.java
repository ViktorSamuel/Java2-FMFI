package sat.tests;

import org.junit.Test;
import sat.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.*;

public class ImplikaciaTest {

    @Test
    public void testEva() {
        // term: (x AND false -> (y OR !z)
        ArrayList<Term> andTerms = new ArrayList<>();
        andTerms.add(new Premenna("x"));
        andTerms.add((new Konstanta(true)).negate());
        And andTerm = new And(andTerms);

        ArrayList<Term> orTerms = new ArrayList<>();
        orTerms.add(new Premenna("y"));
        orTerms.add((new Premenna("z")).negate());
        Or orTerm = new Or(orTerms);

        Implikacia implikacia = new Implikacia(andTerm, orTerm);

        Map<String, Boolean> values = new HashMap<>();
        values.put("x", true);
        values.put("y", false);
        values.put("z", true);

        assertTrue(implikacia.Eval(values));
    }

    @Test
    public void testNegate() {
        Term left = new Premenna("x");
        Term right = (new Premenna("y")).negate();
        Implikacia implikacia = new Implikacia(left, right);

        Term negatedTerm = implikacia.negate();

        assertTrue(negatedTerm instanceof And);
    }

    @Test
    public void testGetVariables() {
        // term: (x OR y) -> (z AND !x)
        ArrayList<Term> orTerms = new ArrayList<>();
        orTerms.add(new Premenna("x"));
        orTerms.add(new Premenna("y"));
        Or orTerm = new Or(orTerms);

        ArrayList<Term> andTerms = new ArrayList<>();
        andTerms.add(new Premenna("z"));
        andTerms.add((new Premenna("x")).negate());
        And andTerm = new And(andTerms);

        Implikacia implikacia = new Implikacia(orTerm, andTerm);

        ArrayList<String> variables = implikacia.getVariables();

        assertTrue(variables.contains("x"));
        assertTrue(variables.contains("y"));
        assertTrue(variables.contains("z"));
    }

    @Test
    public void testIsSatisfiable() {
        // unsatisfiable term: (x OR !x) -> (y AND !y)
        ArrayList<Term> orTerms = new ArrayList<>();
        orTerms.add(new Premenna("x"));
        orTerms.add((new Premenna("x")).negate());
        Or orTerm = new Or(orTerms);

        ArrayList<Term> andTerms = new ArrayList<>();
        andTerms.add(new Premenna("y"));
        andTerms.add((new Premenna("y")).negate());
        And andTerm = new And(andTerms);

        Implikacia implikacia = new Implikacia(orTerm, andTerm);

        assertFalse(implikacia.isSatisfiable());
    }

    @Test
    public void testToString() {
        // term: (x AND !y) -> (z OR w)
        ArrayList<Term> andTerms = new ArrayList<>();
        andTerms.add(new Premenna("x"));
        andTerms.add((new Premenna("y")).negate());
        And andTerm = new And(andTerms);

        ArrayList<Term> orTerms = new ArrayList<>();
        orTerms.add(new Premenna("z"));
        orTerms.add(new Premenna("w"));
        Or orTerm = new Or(orTerms);

        Implikacia implikacia = new Implikacia(andTerm, orTerm);

        assertEquals("((x AND !y) -> (z OR w))", implikacia.toString());
    }
}
