package sat;

import java.util.ArrayList;
import java.util.Map;

public class Implikacia implements Term{
    private Term left;
    private Term right;

    public Implikacia(Term left, Term right){
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean Eval(Map<String, Boolean> values){
        return !left.Eval(values) || right.Eval(values);
    }

    @Override
    public Term negate(){
        ArrayList<Term> terms = new ArrayList<Term>();
        terms.add(left);
        terms.add(right.negate());
        return new And(terms);
    }

    @Override
    public ArrayList<String> getVariables(){
        ArrayList<String> variables = new ArrayList<String>();
        variables.addAll(left.getVariables());
        variables.addAll(right.getVariables());
        return variables;
    }

    @Override
    public boolean isSatisfiable(){
        return left.isSatisfiable() && right.isSatisfiable();
    }

    @Override
    public String toString(){
        return "(" + left.toString() + " -> " + right.toString() + ")";
    }
}
