package org.javaalgorithminterview.ch18_binary_search;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P72_3_Intersection_of_Two_Arrays {

    /**
     * The book solution utilizing a two pointer strategy
     *
     * 1. Sort both input arrays
     * 2. Compare the values that each pointer points at
     * 3. Find the intersection
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        // 1.
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0;
        int j = 0;

        Set<Integer> intersection = new HashSet<>();

        // 2
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                intersection.add(nums1[i]);
                i++;
                j++;
            }
        }
        return intersection.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
