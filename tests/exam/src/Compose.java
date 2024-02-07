import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Compose extends CompositeFun {
    private List<Fun> reversedFunctions;

    public Compose(Fun... functions) {
        super(functions[0], Arrays.copyOfRange(functions, 1, functions.length));
        reversedFunctions = Arrays.asList(functions);
        Collections.reverse(reversedFunctions);
    }

    @Override
    public Double eval(Double input) {
        double result = reversedFunctions.stream()
                .mapToDouble(function -> function.eval(input))
                .reduce((x, y) -> y)
                .orElse(0.0);
        return result;
    }
}
