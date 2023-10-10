package sat;

import java.util.ArrayList;
import java.util.Map;

public class Konstanta implements Term{
    private boolean value;

    public Konstanta(boolean value){
        this.value = value;
    }

    @Override
    public boolean Eval(Map<String, Boolean> values) {
        return value;
    }

    @Override
    public Term negate() {
        return new Konstanta(!value);
    }

    @Override
    public ArrayList<String> getVariables() {
        return new ArrayList<String>();
    }

    @Override
    public boolean isSatisfiable(){
        return true;
    }

    @Override
    public String toString(){
        return value ? "true" : "false";
    }
}
