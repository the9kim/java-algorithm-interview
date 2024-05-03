package org.javaalgorithminterview.ch22_divide_and_conquer;

import java.util.Arrays;

/**
 * The book solution Using sorting
 */
public class P89_4_Majority_Element {

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);

        return nums[nums.length / 2];
    }
}
