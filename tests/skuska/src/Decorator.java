public abstract class Decorator extends Fun {
    protected Fun fun;

    public Decorator(Fun fun) {
        super("Decorator "+fun.getName());
        this.fun = fun;
    }
}
