package org.javaalgorithminterview.ch17_sort;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * The book solution using Insertion sort
 */
public class P67_2_Largest_Number {

    public boolean canSwap(int n1, int n2) {
        return Double.parseDouble(String.valueOf(n2) + n1)
                > Double.parseDouble(String.valueOf(n1) + n2);
    }

    public String largestNumber(int[] nums) {

        // Pointer to remove an element
        int i = 1;

        while (i < nums.length) {
            // Pointer to find the location to insert
            int j = i;

            while (j > 0 && canSwap(nums[j - 1], nums[j])) {
                int temp = nums[j - 1];
                nums[j - 1] = nums[j];
                nums[j] = temp;
                j--;
            }
            i++;
        }

        String answer = Arrays.stream(nums)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(""));

        if (answer.startsWith("0")) {
            return "0";
        }
        return answer;
    }
}
