package Iterator;

public class Main {
    public static void main(String[] args) {
        ConcreteAggregate aggregate = new ConcreteAggregate();
        // Pridanie prvkov do kolekcie...

        Iterator iterator = aggregate.createIterator();
        while (iterator.hasNext()) {
            Object item = iterator.next();
            // Spracovanie prvku
        }
    }
}
