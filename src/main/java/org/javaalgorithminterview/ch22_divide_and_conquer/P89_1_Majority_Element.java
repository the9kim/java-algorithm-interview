package org.javaalgorithminterview.ch22_divide_and_conquer;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class P89_1_Majority_Element {

    Map<Integer, Integer> counter = new HashMap<>();

    public int divideAndConquer(int[] nums, int left, int right) {
        if (left == right){
            counter.put(nums[left], counter.getOrDefault(nums[left], 0) + 1);
            return nums[left];
        }
        int half = left + (right - left) / 2;

        divideAndConquer(nums, left, half);
        divideAndConquer(nums, half + 1, right);

        int maxValue = Collections.max(counter.values());
        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            if (entry.getValue() == maxValue) {
                return entry.getKey();
            }
        }
        return -1;
    }

    public int majorityElement(int[] nums) {
        return divideAndConquer(nums, 0, nums.length - 1);
    }
}
