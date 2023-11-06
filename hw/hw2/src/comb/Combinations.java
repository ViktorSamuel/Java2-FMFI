package comb;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Combinations<T> implements Iterator<List<T>>{
    private final List<T> list;
    private final int k;
    private final int[] indices;
    private boolean hasNext = true;

    public Combinations(List<T> list, int k) {
        this.list = list;
        this.k = k;
        indices = new int[k];
        for (int i = 0; i < k; i++) {
            indices[i] = i;
        }
    }

    @Override
    public boolean hasNext() {
        return hasNext;
    }

    @Override
    public List<T> next() {
        List<T> result = new ArrayList<>(k);
        for (int i = 0; i < k; i++) {
            result.add(list.get(indices[i]));
        }
        int i = k - 1;
        while (i >= 0 && indices[i] == list.size() - k + i) {
            i--;
        }
        if (i < 0) {
            hasNext = false;
        } else {
            indices[i]++;
            for (int j = i + 1; j < k; j++) {
                indices[j] = indices[i] + j - i;
            }
        }
        return result;
    }
}
