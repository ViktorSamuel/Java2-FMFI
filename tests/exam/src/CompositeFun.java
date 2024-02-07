import java.util.Arrays;
import java.util.List;

public abstract class CompositeFun extends Fun {
    protected List<Fun> functions;

    public CompositeFun(Fun fun, Fun... functions) {
        super(fun.strategy);
        this.functions = Arrays.asList(functions);
    }
}