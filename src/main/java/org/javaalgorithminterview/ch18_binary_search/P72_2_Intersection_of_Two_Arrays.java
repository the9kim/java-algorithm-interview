package org.javaalgorithminterview.ch18_binary_search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P72_2_Intersection_of_Two_Arrays {

    /**
     * The book solution utilizing binary search
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        // 1.
        Arrays.sort(nums2);

        // 2.
        Set<Integer> intersection = new HashSet<>();

        for (int num : nums1) {
            int idx = Arrays.binarySearch(nums2, num);

            if (idx >= 0) {
                intersection.add(num);
            }
        }
        return intersection.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
