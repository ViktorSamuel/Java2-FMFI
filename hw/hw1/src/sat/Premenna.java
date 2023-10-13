package sat;

import java.util.ArrayList;
import java.util.Map;

public class Premenna implements Term{
    private String name;

    public Premenna(String name){
        this.name = name;
    }

    @Override
    public boolean Eval(Map<String, Boolean> values) {
        return values.getOrDefault(this.name, false);
    }

    @Override
    public Term negate() {
        return new Negacia(this);
    }

    @Override
    public ArrayList<String> getVariables(){
        ArrayList<String> variables = new ArrayList<String>();
        variables.add(name);
        return variables;
    }

    @Override
    public boolean isSatisfiable(){
        return true;
    }

    @Override
    public String toString(){
        return name;
    }
}
