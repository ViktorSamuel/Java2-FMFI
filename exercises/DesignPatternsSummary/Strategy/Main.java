package Strategy;

public class Main {
    public static void main(String[] args) {
        Context context = new Context(new ConcreteStrategyA());
        context.executeStrategy(); // Použije ConcreteStrategyA

        context = new Context(new ConcreteStrategyB());
        context.executeStrategy(); // Použije ConcreteStrategyB

        context.setStrategy(new ConcreteStrategyA());
        context.executeStrategy(); // Použije ConcreteStrategyA
    }
}
