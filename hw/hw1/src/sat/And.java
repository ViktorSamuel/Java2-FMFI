package sat;

import java.util.ArrayList;
import java.util.Map;

public class And implements Term{
    private ArrayList<Term> terms;

    public And(ArrayList<Term> terms){
        this.terms = terms;
    }

    @Override
    public boolean Eval(Map<String, Boolean> values){
        for(Term term : terms){
            if(!term.Eval(values)){
                return false;
            }
        }
        return true;
    }

    @Override
    public Term negate(){
        ArrayList<Term> negatedTerms = new ArrayList<Term>();
        for(Term term : terms){
            negatedTerms.add(term.negate());
        }
        return new Or(negatedTerms);
    }

    @Override
    public ArrayList<String> getVariables(){
        ArrayList<String> variables = new ArrayList<String>();
        for(Term term : terms){
            variables.addAll(term.getVariables());
        }
        return variables;
    }

    @Override
    public boolean isSatisfiable(){
        for(Term term : terms){
            if(!term.isSatisfiable()){
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString(){
        String result = "(";
        for(int i = 0; i < terms.size(); i++){
            result += terms.get(i).toString();
            if(i < terms.size() - 1){
                result += " AND ";
            }
        }
        result += ")";
        return result;
    }
}
