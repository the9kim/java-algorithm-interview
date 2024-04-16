package org.javaalgorithminterview.ch18_binary_search;

import java.util.Arrays;

public class P71_2_Search_in_Rotated_Sorted_Array {

    /**
     * The book solution
     *
     * 1. Find the pivot this is the min value
     * 2. Find the position of the target using the pivot
     */
    public int search(int[] nums, int target) {

        // 1.
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        int pivot = left;

        // 2.
        left = 0;
        right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midPivot = (mid + pivot) % nums.length;

            if (nums[midPivot] < target) {
                left = mid + 1;
            } else if(nums[midPivot] > target) {
                right = mid - 1;
            } else {
                return midPivot;
            }
        }
        return -1;
    }
}
