package org.javaalgorithminterview.ch22_divide_and_conquer;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * The book solution calculate the number of elements with a Hash map
 */
public class P89_3_Majority_Element {

    public int majorityElement(int[] nums) {
        // 1. Count the number of elements using a Hash map
        Map<Integer, Integer> counter = new HashMap<>();
        for (int num : nums) {
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }

        // 2. Sort the hash map using a linked hash map
        Map<Integer, Integer> reverseSortedCounter = new LinkedHashMap<>();

        counter.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> reverseSortedCounter.put(x.getKey(), x.getValue()));


        // 3. Extract the first value of the linked hash map and check if it is an answer
        Map.Entry<Integer, Integer> entry = reverseSortedCounter.entrySet().iterator().next();

        if (entry.getValue() > nums.length / 2) {
            return entry.getKey();
        }

        return -1;
    }
}
