package org.javaalgorithminterview.ch11_hash_table;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class P33_2_Top_K_Frequent_Elements {

    public int[] topKElement(int[] nums, int k) {
        // 1. calculate the frequency of each element using a hashmap
        Map<Integer, Integer> counter = new HashMap<>();

        for (int n : nums) {
            counter.put(n, counter.getOrDefault(n, 0) + 1);
        }

        // 2. sort the elements in descending order based on their frequency
        int[] sortedElems = counter.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getKey)
                .mapToInt(Integer::intValue)
                .toArray();

        // 3. pick the k most frequent elements and return them
        return Arrays.copyOfRange(sortedElems, 0, k);
    }
}
