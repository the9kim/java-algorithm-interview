package org.javaalgorithminterview.ch18_binary_search;

public class P73_1_Two_Sum {
    public int binarySort(int[] nums, int target, int left, int right) {

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (target < nums[mid]) {
                return binarySort(nums, target, left, mid - 1);
            } else if (target > nums[mid]) {
                return binarySort(nums, target, mid + 1, right);
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * The solution using the binary search which is implemented oneself
     */
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length - 1; i++) {
            int pairIdx = binarySort(numbers, target - numbers[i], i + 1, numbers.length - 1);
            if (pairIdx >= 0) {
                return new int[]{i + 1, pairIdx + 1};
            }
        }
        return null;
    }
}
