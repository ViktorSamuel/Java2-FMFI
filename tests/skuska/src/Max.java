import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Max extends Fun {

    private ArrayList<Fun> functions;

    public Max(Fun... functions) {
        super(Arrays.stream(functions).map(Fun::getName).collect(Collectors.joining(" , ", "{", "}")));
        this.functions = new ArrayList<>(Arrays.asList(functions));
    }

    @Override
    public Double eval(Double x) {
        return functions.stream()
                .mapToDouble(f -> f.eval(x))
                .max()
                .orElse(Double.MIN_VALUE);
    }
}
