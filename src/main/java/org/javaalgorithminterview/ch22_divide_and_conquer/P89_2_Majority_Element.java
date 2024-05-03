package org.javaalgorithminterview.ch22_divide_and_conquer;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * The book solution
 */
public class P89_2_Majority_Element {

    public int divideAndConquer(int[] nums, int left, int right) {
        if (left == right){
            return nums[left];
        }
        int half = left + (right - left) / 2;

        int a = divideAndConquer(nums, left, half);
        int b = divideAndConquer(nums, half + 1, right);

        int countA = 0;
        for (int i = left; i <= right; i++) {
            if (nums[i] == a) {
                countA++;
            }
        }
        return countA > (right - left + 1) / 2 ? a : b;
    }

    public int majorityElement(int[] nums) {
        return divideAndConquer(nums, 0, nums.length - 1);
    }
}
