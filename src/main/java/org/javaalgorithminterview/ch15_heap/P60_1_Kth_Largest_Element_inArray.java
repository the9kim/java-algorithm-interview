package org.javaalgorithminterview.ch15_heap;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Collections;
import java.util.Arrays;
import java.util.stream.Collectors;

public class P60_1_Kth_Largest_Element_inArray {

    public int findKthLargest(int[] nums, int k) {

        List<Integer> numsLst = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toList());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.addAll(numsLst);

        for (int i = 0; i < k - 1; i++) {
            pq.poll();
        }
        return pq.poll();
    }
}
