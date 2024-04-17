package org.javaalgorithminterview.ch18_binary_search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P72_1_Intersection_of_Two_Arrays {
    public boolean binarySearch(int[] nums, int target, int left, int right) {
        if (left <= right) {
            int mid = left + (right - left) / 2;

            if (target <nums[mid]) {
                return binarySearch(nums, target, left, mid - 1);
            } else if (target > nums[mid]) {
                return binarySearch(nums, target, mid + 1, right);
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * it utilizes binary Search resulting in a time complexity of O(n log n)
     *
     * 1. Find out a small input array and big one then Sort input arrays
     * 2. At each iteration in the small array, check if another array contains the element using binary search
     * 3. Extract the intersection
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        // 1
        int[] small = nums1.length <= nums2.length ? nums1 : nums2;
        int[] big = nums1.length > nums2.length ? nums1 : nums2;

        Arrays.sort(small);
        Arrays.sort(big);

        // 2
        List<Integer> intersection = new ArrayList<>();

        for (int i = 0; i < small.length; i++) {
            if (i != 0 && small[i-1] == small[i]) {
                continue;
            }
            if (binarySearch(big, small[i], 0, big.length - 1)) {
                intersection.add(small[i]);
            }
        }

        // 3
        return intersection.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
