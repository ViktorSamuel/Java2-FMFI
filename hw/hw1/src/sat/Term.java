package sat;

import java.util.ArrayList;
import java.util.Map;

public interface Term {
    public boolean Eval(Map<String, Boolean> values);

    public Term negate();

    public ArrayList<String> getVariables();

    public String toString();

    public boolean isSatisfiable();
}
