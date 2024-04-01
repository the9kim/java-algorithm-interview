package org.javaalgorithminterview.ch15_heap;

import java.util.ArrayList;
import java.util.List;

public class P60_2_Kth_Largest_Element_inArray {

    static class BinaryHeap {
        List<Integer> elems;

        public BinaryHeap(List<Integer> elems) {
            this.elems = elems;
            elems.add(null);
        }

        public void swap(int left, int right) {
            Integer temp = elems.set(left, elems.get(right));
            elems.set(right, temp);
        }

        public void percolateUp() {
            int idx = elems.size() - 1;
            int parent = idx / 2;

            while (parent > 0) {

                if (elems.get(idx) > elems.get(parent)) {
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

        public void maxHeapify(int idx) {
            int left = idx * 2;
            int right = idx * 2 + 1;
            int biggest = idx;

            if (left < elems.size() && elems.get(biggest) < elems.get(left)) {
                biggest = left;
            }
            if (right < elems.size() && elems.get(biggest) < elems.get(right)) {
                biggest = right;
            }
            if (biggest != idx) {
                swap(idx, biggest);
                maxHeapify(biggest);
            }
        }

        public int extract() {
            Integer top = elems.get(1);
            Integer bottom = elems.get(elems.size() - 1);
            elems.set(1, bottom);
            elems.remove(elems.size() - 1);
            maxHeapify(1);

            return top;
        }
    }

    public int findKthLargest(int[] nums, int k) {

        BinaryHeap heap = new BinaryHeap(new ArrayList<>());

        for (int num : nums) {
            heap.insert(num);
        }

        for (int i = 0; i < k - 1; i++) {
            heap.extract();
        }
        return heap.extract();
    }
}
