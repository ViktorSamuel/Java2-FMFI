package sat;

import java.util.ArrayList;
import java.util.Map;

public class Premenna implements Term{
    private String name;
    private boolean value;

    public Premenna(String name, boolean value){
        this.name = name;
        this.value = value;
    }

    @Override
    public boolean Eval(Map<String, Boolean> values) {
        return value;
    }

    @Override
    public Term negate() {
        return new Premenna(name, !value);
    }

    @Override
    public ArrayList<String> getVariables(){
        ArrayList<String> variables = new ArrayList<String>();
        variables.add(name);
        return variables;
    }

    @Override
    public boolean isSatisfiable(){
        return value;
    }

    @Override
    public String toString(){
        return name;
    }
}
