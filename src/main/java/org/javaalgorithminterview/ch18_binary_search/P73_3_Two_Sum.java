package org.javaalgorithminterview.ch18_binary_search;

import java.util.Arrays;

public class P73_3_Two_Sum {
    /**
     * The solution using the two pointer strategy
     */
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            if (numbers[left] + numbers[right] < target) {
                left++;
            } else if (numbers[left] + numbers[right] > target) {
                right--;
            }
            return new int[]{left + 1, right + 1};
        }
        return null;
    }
}
