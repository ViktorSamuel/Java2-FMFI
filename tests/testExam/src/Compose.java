import java.util.*;
import java.util.stream.Collectors;

public class Compose extends Function {
    private ArrayList<Function> functions;

    public Compose(Function... functions) {
        super(  Arrays.stream(functions).map(Function::getName).collect(Collectors.joining(" . ","{","}")) );
        this.functions = new ArrayList<>(Arrays.asList(functions));
    }

    @Override
    public Optional<Double> eval(Double input) {
        Collections.reverse(functions);
        Optional<Double> result = functions.stream() //
                .reduce(
                        Optional.of(input), // Počínajúc vstupnou hodnotou zabalenou do príkazu Optional.
                        (opt, function) -> opt.flatMap(function::eval), // Použitie každej funkcie na aktuálny výsledok.
                        (opt1, opt2) -> opt2);
        Collections.reverse(functions);
        return result;
    }

//    public ArrayList<Function> getFunctions() {
//        return new ArrayList<>(functions);
//    }

//    @Override
//    public Optional<Double> eval(Double x) {
//        for (Function function : functions) {
//            System.out.println(function.getName() + " " + x);
//            Optional<Double> result = function.eval(x);
//            if (result.isEmpty()) {
//                return Optional.empty();
//            }
//            x = result.get();
//        }
//        return Optional.of(x);
//    }

//    @Override
//    public Optional<Double> eval(Double x) {
//        ListIterator<Function> listIterator = functions.listIterator(functions.size());
//        while (listIterator.hasPrevious()) {
//            Function function = listIterator.previous();
//            System.out.println(function.getName() + " " + x);
//            Optional<Double> result = function.eval(x);
//            if (result.isEmpty()) {
//                return Optional.empty();
//            }
//            x = result.get();
//        }
//        return Optional.of(x);
//    }

//    @Override
//    public Optional<Double> eval(Double input) {
//        Optional<Double> result = Optional.ofNullable(input);
//        Collections.reverse(functions);
//        for (Function function : functions) {
//            result = result.flatMap(function::eval);
//            if (!result.isPresent()) break;
//        }
//        Collections.reverse(functions);
//        return result;
//    }
}