package command;

// Reciever
public class Calculator implements CalculatorInterface{
    private int accumulator;

    public Calculator() {
        this.accumulator = 0;
    }
    @Override
    public int getAcc(){
        return this.accumulator;
    }
    @Override
    public void setAcc(int newAcc){
        this.accumulator = newAcc;
    }
    @Override
    public void add(int value){
        this.accumulator += value;
    }
    @Override
    public void multiply(int value){
        this.accumulator *= value;
    }
}
