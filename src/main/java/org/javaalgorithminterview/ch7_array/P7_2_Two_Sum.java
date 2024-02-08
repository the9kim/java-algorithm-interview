package org.javaalgorithminterview.ch7_array;

import java.util.HashMap;
import java.util.Map;

public class P7_2_Two_Sum {

    /**
     * 1. Create a map of values to indices
     * 2. check whether the map contains a value(the target value minus each element of the input array)
     */
    public int[] twoSum(int[] nums, int target) {

        // 1
        Map<Integer, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            indexMap.put(nums[i], i);
        }

        // 2
        for (int i = 0; i < nums.length; i++) {
            int subtraction = target - nums[i];
            if (indexMap.containsKey(subtraction) && i != indexMap.get(nums[subtraction])) {
                return new int[]{i, indexMap.get(nums[i])};
            }
        }
        return null;
    }

    public int[] twoSum2(int[] nums, int target) {

        Map<Integer, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int subtraction = target - nums[i];
            if (indexMap.containsKey(subtraction) && i != indexMap.get(subtraction)) {
                return new int[]{i, indexMap.get(subtraction)};
            }
            indexMap.put(nums[i], i);
        }
        return null;
    }
}
