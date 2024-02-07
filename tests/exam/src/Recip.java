

public class Recip extends Fun {
    public Recip() {
        super(new NoapStrategy());
    }
    @Override
    public Double eval(Double x) {
        return 1 / (x * x + 1);
    }
}
