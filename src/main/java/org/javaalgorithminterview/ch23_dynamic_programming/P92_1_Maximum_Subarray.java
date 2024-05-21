package org.javaalgorithminterview.ch23_dynamic_programming;

import java.util.Arrays;

public class P92_1_Maximum_Subarray {
    public int maxSubArray(int[] nums) {

        int sum = 0;
        int[] dp = new int[nums.length];

        for (int right = 0; right < nums.length; right++) {
            if (sum < 0 && nums[right] > sum) {
                sum = nums[right];
            } else {
                sum += nums[right];
            }
            dp[right] = sum;
        }

        return Arrays.stream(dp).max().orElseThrow();
    }
}
