package org.javaalgorithminterview.ch23_dynamic_programming;

import java.util.Arrays;

public class P92_3_Maximum_Subarray {

    /**
     * The book solution using Kadane's Algorithm
     */
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;

        int currentSum = 0;

        for (int i = 0; i < nums.length; i++) {
            currentSum = Math.max(nums[i], nums[i] + currentSum);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }
}
