package Composite;

public class Main {
    public static void main(String[] args) {
        Composite root = new Composite();
        root.add(new Leaf());
        root.add(new Leaf());

        Composite composite = new Composite();
        composite.add(new Leaf());

        root.add(composite);
        root.operation(); // Vykoná operáciu na celom strome

    }
}
