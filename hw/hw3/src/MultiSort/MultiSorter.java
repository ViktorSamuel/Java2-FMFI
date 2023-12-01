package MultiSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class MultiSorter {
    private final int MAX_DEPTH;

    public MultiSorter(int max_depth) {
        this.MAX_DEPTH = max_depth;
    }

    public void sort(ArrayList<Integer> array) {
        int[] arr = array.stream().mapToInt(Integer::intValue).toArray();
        int[] temp = new int[arr.length];

        MultiSortThread sorterThread = new MultiSortThread(arr, temp, 0, arr.length, 0);
        sorterThread.start();

        try {
            sorterThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < arr.length; i++) {
            array.set(i, arr[i]);
        }
    }

    private class MultiSortThread extends Thread {
        private final int[] array;
        private final int[] temp;
        private final int start;
        private final int end;
        private final int depth;

        MultiSortThread(int[] array, int[] temp, int start, int end, int depth) {
            this.array = array;
            this.temp = temp;
            this.start = start;
            this.end = end;
            this.depth = depth;
        }

        @Override
        public void run() {
            if (depth >= MAX_DEPTH) {
                Arrays.sort(array, start, end);
            } else {
                int middle = (start + end) / 2;

                MultiSortThread leftThread = new MultiSortThread(array, temp, start, middle, depth + 1);
                MultiSortThread rightThread = new MultiSortThread(array, temp, middle, end, depth + 1);

                leftThread.start();
                rightThread.start();

                try {
                    leftThread.join();
                    rightThread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                merge(start, middle, end);
            }
        }

        private void merge(int start, int middle, int end) {
            int i = start;
            int j = middle;
            int k = start;

            while (i < middle && j < end) {
                if (array[i] <= array[j]) {
                    temp[k++] = array[i++];
                } else {
                    temp[k++] = array[j++];
                }
            }

            while (i < middle) {
                temp[k++] = array[i++];
            }

            while (j < end) {
                temp[k++] = array[j++];
            }

            System.arraycopy(temp, start, array, start, end - start);
        }
    }
}
