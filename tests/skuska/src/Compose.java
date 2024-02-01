import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class Compose extends Fun {
    private ArrayList<Fun> functions;

    public Compose(Fun... functions) {
        super( Arrays.stream(functions).map(Fun::getName).collect(Collectors.joining(" . ","{","}")) );
        this.functions = new ArrayList<>(Arrays.asList(functions));
    }

    @Override
    public Double eval(Double input) {
        Collections.reverse(functions);
        double result = functions.stream()
                .mapToDouble(function -> function.eval(input))
                .reduce((x, y) -> y) // In case you need to combine the results in a specific way
                .orElse(0.0); // Default value if no functions are present
        Collections.reverse(functions);
        return result;
    }
}
