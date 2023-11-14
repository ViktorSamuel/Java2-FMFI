package command;

public class MultiplyCommand implements Command{
    private Calculator calculator;
    private int value;

    public MultiplyCommand(Calculator calculator, int value) {
        this.calculator = calculator;
        this.value = value;
    }

    @Override
    public void execute(){
        calculator.multiply(value);
    }

    @Override
    public void undo(){
        calculator.multiply(1/value);
    }
}
