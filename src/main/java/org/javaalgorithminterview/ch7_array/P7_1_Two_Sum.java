package org.javaalgorithminterview.ch7_array;

import java.util.Arrays;

public class P7_1_Two_Sum {

    /**
     * 1. Utilize double iteration.
     * 2. Calculate the sum two elements.
     * 3. Compare the target with the sum.
     */
    public int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    /**
     * 1. Pick an element, A, and subtract it from the target
     * 2. check if the 'nums' array has another element that results from subtracting A from the target.
     */
    public int[] twoSum2(int[] nums, int target) {

        int[] answer = new int[2];

        for (int i = 0; i < nums.length; i++) {
            int subtraction = target - nums[i];
            int index = Arrays.binarySearch(nums, subtraction);
            if (subtraction > 0 && index != -(nums.length + 1)) {
                answer[0] = i;
                answer[1] = index;
            }
        }
        return answer;
    }

}
