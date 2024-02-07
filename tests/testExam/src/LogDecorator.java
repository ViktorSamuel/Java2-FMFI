import java.util.Optional;

public class LogDecorator extends Decorator {
    //private Function function;

    public LogDecorator(Function function) {
        //super("LogDec[" + function.getName() + "]");
        super(function);
        //this.function = function;
    }

    @Override
    public String getName() {
        return "LogDec[" + function.getName()+"]";
    }

    @Override
    public Optional<Double> eval(Double input) {
        Optional<Double> result = function.eval(input);
        System.out.println("log[" + function.getName() + "]" + " with input " + input + " returned " + result);
        return result;
    }
}
