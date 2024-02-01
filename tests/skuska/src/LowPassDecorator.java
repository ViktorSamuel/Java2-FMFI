

public class LowPassDecorator extends Decorator {
    private Fun g, f;

    public LowPassDecorator(Fun g, Fun f) {
        super(f);
        this.g = g;
        this.f = f;
    }

    @Override
    public Double eval(Double x){
        if(f.eval(x) < g.eval(x))
            return f.eval(x);
        else
            return g.eval(x);
    }
}
