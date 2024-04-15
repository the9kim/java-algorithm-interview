package org.javaalgorithminterview.ch18_binary_search;

import java.util.Arrays;

public class P70_3_Binary_Search {

    /**
     * Binary Search method
     */
    public int search(int[] nums, int target) {
        return Arrays.binarySearch(nums, target) >= 0 ? Arrays.binarySearch(nums, target) : -1;
    }
}
