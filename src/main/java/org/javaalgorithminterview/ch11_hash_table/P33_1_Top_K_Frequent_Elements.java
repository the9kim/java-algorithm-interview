package org.javaalgorithminterview.ch11_hash_table;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class P33_1_Top_K_Frequent_Elements {

    /**
     * 1. Calculate the frequency of elements in the input Array.
     * 2. Sort the hash map based on values using an entry set.
     * 3. Extract top k frequent elements.
     */
    public int[] topKElement(int[] nums, int k) {
        int[] answer = new int[k];

        // 1
        Map<Integer, Integer> freqs = new HashMap<>();
        for (int num : nums) {
            freqs.put(num, freqs.getOrDefault(num, 0) + 1);
        }

        // 2.
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(freqs.entrySet());
        entryList.sort(Map.Entry.<Integer, Integer>comparingByValue().reversed());

        // 3.
        for (int i = 0; i < k; i++) {
            answer[i] = entryList.get(i).getKey();
        }

        return answer;
    }

    /**
     * Sort the hash map based on values Using Priority Queue.
     */
    public int[] topKElement2(int[] nums, int k) {

        // 1
        Map<Integer, Integer> freqs = new HashMap<>();
        for (int num : nums) {
            freqs.put(num, freqs.getOrDefault(num, 0) + 1);
        }

        // 2
//        PriorityQueue<int[]> pq = new PriorityQueue<>(
//                (o1, o2) -> {
//                    if (o1[1] > o2[1]) {
//                        return -1;
//                    } else if (o1[1] < o2[1]) {
//                        return 1;
//                    } else {
//                        return 0;
//                    }
//                });
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);

        for (Integer key : freqs.keySet()) {
            int[] e = new int[]{key, freqs.get(key)};
            pq.add(e);
        }

        // 3
        int[] answer = new int[k];
        for (int i = 0; i < k; i++) {
            answer[i] = pq.poll()[0];
        }

        return answer;
    }
}
