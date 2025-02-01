package org.javaalgorithminterview.ch11_hash_table;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class P33_2_Top_K_Frequent_Elements {

    public int[] topKElement(int[] nums, int k) {
        Map<Integer, Integer> counter = new HashMap<>();

        for (int n : nums) {
            counter.put(n, counter.getOrDefault(n, 0) + 1);
        }

        List<Integer> values = counter.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        List<Integer> topK = values.subList(0, k);

        return topK.stream().mapToInt(Integer::intValue).toArray();
    }
}
