package Iterator;

import java.util.*;

public class ConcreteAggregate implements Aggregate {
    private List<Object> items = new ArrayList<>();

    public Iterator createIterator() {
        //return new ConcreteIterator(this);
        return null;
    }

    public int size() {
        return items.size();
    }

    public Object get(int index) {
        return items.get(index);
    }

    // Metódy na pridanie alebo odobratie prvkov z kolekcie...
}
