public class TimeShiftDecorator extends Decorator {
    private Fun f;
    private Double delta;

    public TimeShiftDecorator(Fun f, Double delta) {
        super(f);
        this.f = f;
        this.delta = delta;
    }

    @Override
    public Double eval(Double x){
        return f.eval(x-delta);
    }
}
