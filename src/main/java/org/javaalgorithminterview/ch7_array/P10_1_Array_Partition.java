package org.javaalgorithminterview.ch7_array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class P10_1_Array_Partition {

    /**
     * 1. Sort an array of integers
     * 2. Get the mininum value of each pair
     * 3. Calculate the sum of all the minimum values
     */
    public int arrayPairSum(int[] nums) {

        int sum = 0;

        // 1
        Arrays.sort(nums);

        // 2
        for (int i = 0; i < nums.length; i += 2) {
            int minOfPair = Math.min(nums[i], nums[i + 1]);
            sum += minOfPair;
        }
        return sum;
    }

    public int arrayPairSum2(int[] nums) {
        int sum = 0;
        List<Integer> partition = new ArrayList<>();

        // 1
        Arrays.sort(nums);


        // 2
        for (int num : nums) {
            partition.add(num);

            if (partition.size() == 2) {
                sum += Collections.min(partition);
                partition.clear();
            }
        }

        return sum;
    }

}
