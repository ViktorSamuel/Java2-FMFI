import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class Compose extends CompositeFun {

    public Compose(Fun... functions) {
        super(functions[0], Arrays.copyOfRange(functions, 1, functions.length));
    }

    @Override
    public Double eval(Double input) {
        Collections.reverse(functions);
        double result = functions.stream()
                .mapToDouble(function -> function.eval(input))
                .reduce((x, y) -> y)
                .orElse(0.0);
        Collections.reverse(functions);
        return result;
    }
}
