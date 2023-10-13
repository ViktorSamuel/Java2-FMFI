package sat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Satisfiable {
    public static boolean isSatisfiable(int size, Term term){
        int n = (1 << size);
        for(int i = 0; i < n; i++){
            Map<String, Boolean> values = new HashMap<>();
            for(int j = 0; j < size; j++){
                values.put(term.getVariables().get(j), (i & (1 << j)) != 0);
            }
            if(term.Eval(values)){
                return true;
            }
        }
        return false;
    }
}
