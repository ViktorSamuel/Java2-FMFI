import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Prod extends CompositeFun {

        public Prod(Fun... functions) {
            super(functions[0], Arrays.copyOfRange(functions, 1, functions.length));
        }

        @Override
        public Double eval(Double x) {
            return functions.stream()
                    .mapToDouble(f -> f.eval(x))
                    .reduce(1, (a, b) -> a * b);
        }
}
