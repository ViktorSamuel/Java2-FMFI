import java.util.Iterator;

public class Range implements Iterable<Integer>{

    private int upperBound;
    private int lowerBound;
    private int step = 1;

    public Range(int upperBound) {
        this.upperBound = upperBound;
    }

    public Range(int lowerBound, int upperBound) {
        this.upperBound = upperBound;
    }

    public Range(int lowerBound, int upperBound, int step) {
        this.upperBound = upperBound;
        this.lowerBound = lowerBound;
        this.step = step;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new RangeIterator(lowerBound, upperBound, step);
    }

    private class RangeIterator implements Iterator<Integer> {
        private int current;
        private int upperBound;
        private int step;
        private int counter = 1;

        public RangeIterator(int lowerBound, int upperBound, int step) {
            this.current = lowerBound;
            this.upperBound = upperBound;
            this.step = step;
        }

        @Override
        public boolean hasNext() {
            return current < upperBound;
        }

        @Override
        public Integer next() {
            if (!hasNext()) {
                return null;
            }
            if (step != 1) counter++;
            return current+counter*step;
        }
    }
}
