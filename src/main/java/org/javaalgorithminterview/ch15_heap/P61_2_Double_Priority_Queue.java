package org.javaalgorithminterview.ch15_heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class P61_2_Double_Priority_Queue {

    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (String operation : operations) {
            String[] op = operation.split(" ");

            if ("I".equals(op[0])) {
                minHeap.offer(Integer.valueOf(op[1]));
                maxHeap.offer(Integer.valueOf(op[1]));
            } else if ("D".equals(op[0])) {
                if ("1".equals(op[1])) {
                    minHeap.remove(maxHeap.poll());
                } else if ("-1".equals(op[1])) {
                    maxHeap.remove(minHeap.poll());
                }
            }
        }

        Integer min = minHeap.poll();
        Integer max = maxHeap.poll();

        return new int[]{
                (max == null) ? 0 : max,
                (min == null) ? 0 : min
        };
    }
}
