import java.util.Optional;

public class SlowDecorator extends Decorator {
    //private Function function;

    public SlowDecorator(Function function) {
        //super("SlowDec[" + function.getName() + "]");
        super(function);
        //this.function = function;
    }

    @Override
    public String getName() {
        return "SlowDec[" + function.getName()+"]";
    }

    @Override
    public Optional<Double> eval(Double input) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return function.eval(input);
    }
}
