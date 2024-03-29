package org.javaalgorithminterview.ch15_heap;

import java.util.ArrayList;
import java.util.List;

public class BinaryHeap {
    List<Integer> elems;

    public BinaryHeap() {
        elems = new ArrayList<>();
        elems.add(null);
    }

    public BinaryHeap(List<Integer> elems) {
        this.elems = elems;
    }

    public void swap(int i, int j) {
        Integer temp = elems.set(i, elems.get(j));
        elems.set(j, temp);
    }

    public void percolateUp() {

        int idx = elems.size() - 1;

        int parent = idx / 2;

        while (parent > 0) {
            if (elems.get(parent) > elems.get(idx)) {
                swap(idx, parent);
            }
            idx = parent;
            parent = idx / 2;
        }
    }

    public void insert(int k) {
        elems.add(k);
        percolateUp();
    }

    public void minHeapify(int i) {
        int left = i * 2;
        int right = i * 2 + 1;

        int min = i;

        if (left < elems.size() && elems.get(i) > elems.get(left)) {
            min = left;
        }
        if (right < elems.size() && elems.get(i) > elems.get(right)) {
            min = right;
        }
        if (min != i) {
            swap(i, min);
            minHeapify(min);
        }
    }

    public int extract() {
        int top = elems.get(1);
        int end = elems.get(elems.size() - 1);
        elems.set(1, end);
        elems.remove((Object) end);

        minHeapify(1);

        return top;
    }
}
