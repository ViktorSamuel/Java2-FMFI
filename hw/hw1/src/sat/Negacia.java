package sat;

import java.util.ArrayList;
import java.util.Map;

public class Negacia implements Term{
    private Term term;

    public Negacia(Term term){
        this.term = term;
    }

    public boolean Eval(Map<String, Boolean> values){
        return !term.Eval(values);
    }

    public Term negate(){
        return term;
    }

    public ArrayList<String> getVariables(){
        return term.getVariables();
    }

    public boolean isSatisfiable(){
        return true;
    }

    public String toString(){
        return "!" + term.toString();
    }
}
