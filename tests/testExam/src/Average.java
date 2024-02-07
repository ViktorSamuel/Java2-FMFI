import java.util.*;
import java.util.stream.Collectors;

public class Average extends Function {
    private ArrayList<Function> functions;

    public Average(Function... functions) {
        super("Average[" + Arrays.stream(functions).map(Function::getName).collect(Collectors.joining(", ")) + "]");
        this.functions = new ArrayList<>(Arrays.asList(functions));
    }

    @Override
    public Optional<Double> eval(Double input) {
        return functions.stream()
                .map(f -> f.eval(input))// Convert Function to Optional<Double>
                .filter(Optional::isPresent)// Filter out empty Optional<Double>
                .mapToDouble(Optional::get)// Convert Optional<Double> to DoubleStream
                .average()// Convert Optional<Double> to OptionalDouble
                .stream() // Convert OptionalDouble to a DoubleStream
                .boxed() // Box the primitive double to a Double
                .findFirst(); // Convert DoubleStream to Optional<Double>
    }

    public ArrayList<Function> getFunctions() {
        return new ArrayList<>(functions);
    }
}