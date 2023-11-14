package Decorator;

public class Main {
    public static void main(String[] args) {
        Component component = new ConcreteComponent();
        component = new ConcreteDecoratorA(component);
        component = new ConcreteDecoratorB(component);

        component.operation(); // Vykonáva operácie s pridanými funkcionalitami

    }
}
