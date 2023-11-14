package command;

public class AddCommand implements Command{
    private Calculator calculator;
    private int value;

    public AddCommand(Calculator calculator, int value) {
        this.calculator = calculator;
        this.value = value;
    }

    @Override
    public void execute(){
        calculator.add(value);
    }

    @Override
    public void undo(){
        calculator.add(-value);
    }

}
