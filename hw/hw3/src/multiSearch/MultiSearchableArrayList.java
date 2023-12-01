package multiSearch;

import java.util.ArrayList;
import java.util.List;

public class MultiSearchableArrayList<T> extends ArrayList<T> {
    private final int MAX_THREADS_NUM = 4;

    public MultiSearchableArrayList(List<T> list) {
        super(list);
    }

    public MultiSearchableArrayList() {
        super();
    }

    @Override
    public boolean contains(Object obj) {
        int size = size();
        int chunkSize = size / MAX_THREADS_NUM;

        List<SearchThread> threads = new ArrayList<>();

        for (int i = 0; i < MAX_THREADS_NUM; i++) {
            int startIdx = i * chunkSize;
            int endIdx = (i == MAX_THREADS_NUM - 1) ? size : (i + 1) * chunkSize;

            SearchThread thread = new SearchThread(obj, startIdx, endIdx);
            thread.start();
            threads.add(thread);
        }

        for (SearchThread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (SearchThread thread : threads) {
            if (thread.isElementFound()) {
                return true;
            }
        }

        return false;
    }

    private class SearchThread extends Thread {
        private final Object target;
        private final int startIdx;
        private final int endIdx;
        private boolean elementFound;

        SearchThread(Object target, int startIdx, int endIdx) {
            this.target = target;
            this.startIdx = startIdx;
            this.endIdx = endIdx;
            this.elementFound = false;
        }

        @Override
        public void run() {
            for (int i = startIdx; i < endIdx; i++) {
                if (get(i).equals(target)) {
                    elementFound = true;
                    break;
                }
            }
        }

        boolean isElementFound() {
            return elementFound;
        }
    }
}