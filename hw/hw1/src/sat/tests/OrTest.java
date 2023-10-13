package sat.tests;

import org.junit.Test;
import sat.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.*;

public class OrTest {

    @Test
    public void testEval() {
        // term: (x OR !true) OR (y AND !z)
        ArrayList<Term> orTerms = new ArrayList<>();
        orTerms.add(new Premenna("x"));
        orTerms.add((new Konstanta(true)).negate());
        Or orTerm1 = new Or(orTerms);

        ArrayList<Term> andTerms = new ArrayList<>();
        andTerms.add(new Premenna("y"));
        andTerms.add((new Premenna("z")).negate());
        And andTerm = new And(andTerms);

        ArrayList<Term> orTerms2 = new ArrayList<>();
        orTerms2.add(orTerm1);
        orTerms2.add(andTerm);
        Or orTerm2 = new Or(orTerms2);

        Map<String, Boolean> values = new HashMap<>();
        values.put("x", false);
        values.put("y", false);
        values.put("z", false);

        assertFalse(orTerm2.Eval(values));
    }

    @Test
    public void testNegate() {
        // term: (x OR y) OR !z
        ArrayList<Term> orTerms = new ArrayList<>();
        orTerms.add(new Premenna("x"));
        orTerms.add(new Premenna("y"));
        Or orTerm1 = new Or(orTerms);

        Term notZ = (new Premenna("z")).negate();

        ArrayList<Term> orTerms2 = new ArrayList<>();
        orTerms2.add(orTerm1);
        orTerms2.add(notZ);
        Or orTerm2 = new Or(orTerms2);

        Term negatedTerm = orTerm2.negate();

        assertTrue(negatedTerm instanceof And);
    }

    @Test
    public void testGetVariables() {
        // term: (x OR y) OR (z OR !x)
        ArrayList<Term> orTerms = new ArrayList<>();
        orTerms.add(new Premenna("x"));
        orTerms.add(new Premenna("y"));
        Or orTerm1 = new Or(orTerms);

        ArrayList<Term> orTerms2 = new ArrayList<>();
        orTerms2.add(orTerm1);
        orTerms2.add(new Premenna("z"));
        orTerms2.add((new Premenna("x")).negate());
        Or orTerm2 = new Or(orTerms2);

        ArrayList<String> variables = orTerm2.getVariables();

        assertTrue(variables.contains("x"));
        assertTrue(variables.contains("y"));
        assertTrue(variables.contains("z"));
    }

    @Test
    public void testIsSatisfiable() {
        // term: (x OR y) OR (z OR !x)
        ArrayList<Term> orTerms = new ArrayList<>();
        orTerms.add(new Premenna("x"));
        orTerms.add(new Premenna("y"));
        Or orTerm1 = new Or(orTerms);

        ArrayList<Term> orTerms2 = new ArrayList<>();
        orTerms2.add(orTerm1);
        orTerms2.add(new Premenna("z"));
        orTerms2.add((new Premenna("x")).negate());
        Or orTerm2 = new Or(orTerms2);

        assertTrue(orTerm2.isSatisfiable());
    }

    @Test
    public void testToString() {
        // term: (x OR !y) OR (z OR w)
        ArrayList<Term> orTerms = new ArrayList<>();
        orTerms.add(new Premenna("x"));
        orTerms.add((new Premenna("y")).negate());
        Or orTerm1 = new Or(orTerms);

        ArrayList<Term> orTerms2 = new ArrayList<>();
        orTerms2.add(orTerm1);
        orTerms2.add(new Premenna("z"));
        orTerms2.add(new Premenna("w"));
        Or orTerm2 = new Or(orTerms2);

        assertEquals("((x OR !y) OR z OR w)", orTerm2.toString());
    }
}
