package org.javaalgorithminterview.ch18_binary_search;

import java.util.Arrays;

public class P73_2_Two_Sum {
    /**
     * The solution using the binary search library method
     */
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length - 1; i++) {
            int expected = target - numbers[i];
            int pairIdx = Arrays.binarySearch(numbers, i + 1, numbers.length, expected);
            if (pairIdx >= 0) {
                return new int[]{i + 1, pairIdx + 1};
            }
        }
        return null;
    }
}
