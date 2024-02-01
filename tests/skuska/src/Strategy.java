import java.util.Optional;

public interface Strategy {
    Optional<Double> eval(Double x);
}
