import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Prod extends Fun {

        private ArrayList<Fun> functions;

        public Prod(Fun... functions) {
            super(Arrays.stream(functions).map(Fun::getName).collect(Collectors.joining(" * ", "{", "}")));
            this.functions = new ArrayList<>(Arrays.asList(functions));
        }

        @Override
        public Double eval(Double x) {
            return functions.stream()
                    .mapToDouble(f -> f.eval(x))
                    .reduce(1, (a, b) -> a * b);
        }
}
