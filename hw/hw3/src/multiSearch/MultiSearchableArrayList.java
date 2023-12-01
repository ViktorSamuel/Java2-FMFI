package multiSearch;

import java.util.ArrayList;
import java.util.List;

// zachovajte hlavicky triedy bez zmeny
public class MultiSearchableArrayList<T> extends ArrayList<T> {
    private final int MAX_THREADS_NUM = 5; // alebo 4, nie je to principialne

    // mozete menit vnutro tejto triedy ako chcete, je to len minimalna verzia, ktora sa este kompiluje ;)

    public MultiSearchableArrayList(List<T> list) {
        // @TODO ...
    }

    public MultiSearchableArrayList() {
        // @TODO ...
    }

    // @TODO zmenit funkciu contains

    // @TODO inner class extends Thread
}
