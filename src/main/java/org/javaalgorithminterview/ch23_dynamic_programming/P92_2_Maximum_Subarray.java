package org.javaalgorithminterview.ch23_dynamic_programming;

import java.util.Arrays;

public class P92_2_Maximum_Subarray {

    /**
     * The book solution optimizing space complexity
     */
    public int maxSubArray(int[] nums) {

        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i] + (nums[i - 1] > 0 ? nums[i - 1] : 0);
        }

        return Arrays.stream(nums).max().getAsInt();
    }
}
