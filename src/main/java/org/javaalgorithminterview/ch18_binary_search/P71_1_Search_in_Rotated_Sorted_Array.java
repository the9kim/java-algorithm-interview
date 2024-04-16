package org.javaalgorithminterview.ch18_binary_search;

import java.util.Arrays;

public class P71_1_Search_in_Rotated_Sorted_Array {

    public int binarySearch(int[] nums, int target, int left, int right) {
        if (left > right) {
            return -1;
        }

        int mid = left + (right - left) / 2;

        if (target < nums[mid]) {
            return binarySearch(nums, target, left, mid - 1);
        } else if (target > nums[mid]) {
            return binarySearch(nums, target, mid + 1, right);
        } else {
            return mid;
        }
    }
    public int search(int[] nums, int target) {
        // 1. Find the distance between the rotated array and the sorted array
        int rotatedVal = nums[0];
        Arrays.sort(nums);
        int sortedIdx = binarySearch(nums, rotatedVal, 0, nums.length - 1);
        int dist = nums.length - sortedIdx;

        // 2. Find the position of the target element in the sorted Array
        int position = binarySearch(nums, target, 0, nums.length - 1);

        // 3. Calculate the position of the target in the rotated Array
        return position == -1 ? -1 : (position + dist) % nums.length;
    }
}
