package org.javaalgorithminterview.ch18_binary_search;

public class P70_1_Binary_Search {
    public int binarySearch(int[] nums, int target, int left, int right) {
        if (left > right) {
            return -1;
        }

        // If you calculate the middle index with the expression((left + right) / 2)
        // and there is a border value of a data type between right and (left + right),
        // an overflow could happen
        int middleIdx = left + (right - left + 1) / 2;

        if (nums[middleIdx] > target) {
            return binarySearch(nums, target, left, middleIdx - 1);
        } else if(nums[middleIdx] < target) {
            return binarySearch(nums, target, middleIdx + 1, right);
        } else {
            return middleIdx;
        }
    }

    /**
     * 1. Find a middle element of an input array
     * 2. Divide the search interval in half
     * 3. Compare the target value with the middle element of the array
     */
    public int search(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length - 1);
    }
}
