public abstract class Decorator extends Function{
    protected Function function;

    public Decorator(Function function){
        super("Decorator[" + function.getName() + "]");
        this.function = function;
    }
}
