import java.util.Optional;
public abstract class Function {
    private String name;

    public Function(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract Optional<Double> eval(Double x);
}
