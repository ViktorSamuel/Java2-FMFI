import java.util.Arrays;

public class Max extends CompositeFun {

    public Max(Fun... functions) {
        super(functions[0], Arrays.copyOfRange(functions, 1, functions.length));
    }

    @Override
    public Double eval(Double x) {
        return functions.stream()
                .mapToDouble(f -> f.eval(x))
                .max()
                .orElse(Double.MIN_VALUE);
    }
}
