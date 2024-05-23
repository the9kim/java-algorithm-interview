package org.javaalgorithminterview.ch23_dynamic_programming;

public class P94_2_House_Robber {

    /**
     * Recursive brute force
     *
     * Time exceeded
     */

    public int rob(int[] nums) {
        return rob(nums, nums.length - 1);
    }

    private int rob(int[] nums, int n) {
        if (n < 0) {
            return 0;
        }

        return Math.max(rob(nums, n - 1), nums[n] + rob(nums, n - 2));
    }
}
