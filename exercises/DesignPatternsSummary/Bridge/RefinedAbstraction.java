package Bridge;

public class RefinedAbstraction extends Abstraction{
    public RefinedAbstraction(Implementor implementor) {
        super(implementor);
    }

    public void operation() {
        implementor.operationImpl();
    }
}
