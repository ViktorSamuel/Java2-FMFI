package Iterator;


import java.util.*;

public class ConcreteIterator implements Iterator {
    private Collection collection;
    private int currentIndex = 0;

    public ConcreteIterator(Collection collection) {
        this.collection = collection;
    }

    public boolean hasNext() {
        return currentIndex < collection.size();
    }

    public Object next() {
        if (this.hasNext()) {
            //return collection.get(currentIndex++);
        }
        return null;
    }
}
