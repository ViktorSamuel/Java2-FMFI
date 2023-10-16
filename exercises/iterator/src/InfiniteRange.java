import java.util.Iterator;

public class InfiniteRange implements Iterable<Integer>{
    private int start;
    private int step = 1;

    public InfiniteRange(int start) {
        this.start = start;
    }

    public InfiniteRange(int start, int step) {
        this.start = start;
        this.step = step;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new InfiniteRangeIterator(start, step);
    }

    private class InfiniteRangeIterator implements Iterator<Integer> {
        private int current;
        private int step;
        private int counter = 1;

        public InfiniteRangeIterator(int start, int step) {
            this.current = start;
            this.step = step;
        }

        @Override
        public boolean hasNext() {
            return true;
        }

        @Override
        public Integer next() {
            if (step != 1) counter++;
            return current+counter*step;
        }
    }
}
