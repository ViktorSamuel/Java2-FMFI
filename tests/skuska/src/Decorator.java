public abstract class Decorator extends Fun {
    protected Fun fun;

    public Decorator(Fun fun) {
        super(fun.strategy);
        this.fun = fun;
    }
}
