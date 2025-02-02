package org.javaalgorithminterview.ch11_hash_table;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class P33_2_Top_K_Frequent_Elements {

    public int[] topKElement(int[] nums, int k) {
        Map<Integer, Integer> counter = new HashMap<>();

        for (int n : nums) {
            counter.put(n, counter.getOrDefault(n, 0) + 1);
        }

        List<Integer> sortedKeys = counter.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        return sortedKeys.subList(0, k).stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
