package org.javaalgorithminterview.ch15_heap;

import java.util.ArrayList;
import java.util.List;

public class P61_1_Double_Priority_Queue {

    static class BinaryHeap {
        List<Integer> minElems = new ArrayList<>();
        List<Integer> maxElems = new ArrayList<>();

        public BinaryHeap() {
            minElems.add(null);
            maxElems.add(null);
        }

        public void swap(int left, int right, List<Integer> elems) {
            Integer temp = elems.set(left, elems.get(right));
            elems.set(right, temp);
        }

        public void minPercolateUp() {
            int idx = minElems.size() - 1;
            int parent = idx / 2;

            while (parent > 0) {
                if (minElems.get(idx) < minElems.get(parent)) {
                    swap(idx, parent, this.minElems);
                }
                idx = parent;
                parent = idx / 2;
            }
        }

        public void maxPercolateUp() {
            int idx = maxElems.size() - 1;
            int parent = idx / 2;

            while (parent > 0) {
                if (maxElems.get(idx) > maxElems.get(parent)) {
                    swap(idx, parent, maxElems);
                }
                idx = parent;
                parent = idx / 2;
            }
        }

        public void insert(int k) {
            minElems.add(k);
            maxElems.add(k);

            minPercolateUp();
            maxPercolateUp();
        }

        public void minHeapify(int idx) {
            int left = idx * 2;
            int right = idx * 2 + 1;
            int smallest = idx;

            if (left < minElems.size() && minElems.get(smallest) > minElems.get(left)) {
                smallest = left;
            }
            if (right < minElems.size() && minElems.get(smallest) > minElems.get(right)) {
                smallest = right;
            }

            if (idx != smallest) {
                swap(idx, smallest, minElems);
                minHeapify(smallest);
            }
        }

        public void maxHeapify(int idx) {
            int left = idx * 2;
            int right = idx * 2 + 1;
            int biggest = idx;

            if (left < maxElems.size() && maxElems.get(biggest) < maxElems.get(left)) {
                biggest = left;
            }
            if (right < maxElems.size() && maxElems.get(biggest) < maxElems.get(right)) {
                biggest = right;
            }

            if (idx != biggest) {
                swap(idx, biggest, maxElems);
                maxHeapify(biggest);
            }
        }

        public int extractMin() {
            if (minElems.size() > 1) {
                Integer top = minElems.get(1);
                minElems.set(1, minElems.get(minElems.size() - 1));
                minElems.remove(minElems.size() - 1);

                minHeapify(1);

                int maxIdx = maxElems.indexOf(top);
                maxElems.set(maxIdx, maxElems.get(maxElems.size() - 1));
                maxElems.remove(maxElems.size() - 1);

                maxHeapify(maxIdx);

                return top;
            }

            return 0;
        }

        public int extractMax() {
            if (maxElems.size() > 1) {
                Integer top = maxElems.get(1);
                maxElems.set(1, maxElems.get(maxElems.size() - 1));
                maxElems.remove(maxElems.size() - 1);

                maxHeapify(1);

                int minIdx = minElems.indexOf(top);
                minElems.set(minIdx, minElems.get(minElems.size() - 1));
                minElems.remove(minElems.size() - 1);

                minHeapify(minIdx);

                return top;
            }
            return 0;
        }
    }

    public int[] solution(String[] operations) {
        BinaryHeap heap = new BinaryHeap();

        for (String o : operations) {
            if (o.charAt(0) == 'I') {
                int k = Integer.parseInt(o.substring(2, o.length()));
                heap.insert(k);

            } else if (o.equals("D 1")) {
                heap.extractMax();

            } else if (o.equals("D -1")) {
                heap.extractMin();
            }
        }

        if (heap.minElems.size() > 1 && heap.maxElems.size() > 1) {
            return new int[]{heap.maxElems.get(1), heap.minElems.get(1)};
        }
        return new int[]{0, 0};
    }

}
