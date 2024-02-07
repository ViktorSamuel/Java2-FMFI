import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.Optional;
public class Sin extends Function implements Serializable {
    private static volatile Sin instance;

    private Sin() {
        super("Sin");
    }

    public static Sin getInstance() {
        if (instance == null) {
            synchronized (Sin.class) {
                if (instance == null) {
                    instance = new Sin();
                }
            }
        }
        return instance;
    }

    private Object readResolve() throws ObjectStreamException {
        return getInstance();
    }


    @Override
    public Optional<Double> eval(Double x) {
        return Optional.of(Math.sin(x));
    }
}