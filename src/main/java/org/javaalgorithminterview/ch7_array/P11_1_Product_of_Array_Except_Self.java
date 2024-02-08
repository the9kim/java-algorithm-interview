package org.javaalgorithminterview.ch7_array;

import java.util.Arrays;

public class P11_1_Product_of_Array_Except_Self {

    /**
     * Time Exceeded
     */
    public int[] productExceptSelf(int[] nums) {

        int[] answer = new int[nums.length];
        Arrays.fill(answer, 1);

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i == j) {
                    continue;
                }
                answer[i] *= nums[j];
            }
        }

        return answer;

    }

    /**
     * Time exceeded
     * I couldn't utilize cumulative multiplication to achieve the desired result.
     *
     * 1. Obtain the product of the sub-array
     * 2. Calculate the product of the input-array
     * 3. Compute the product of the sub-Array and the input-array
     */
    public int[] productExceptSelf2(int[] nums) {

        int[] answer = new int[nums.length];
        Arrays.fill(answer, 1);

        int inputMultiple = 1;

        for (int i = 0; i < nums.length; i++) {
            // 1.
            int subMultiple = Arrays.stream(Arrays.copyOfRange(nums, i + 1, nums.length))
                    .reduce(1, (a, b) -> a * b);

            // 2.
            if (i > 0) {
                inputMultiple = Arrays.stream(Arrays.copyOfRange(nums, 0, i))
                        .reduce(1, (a, b) -> a * b);
            }
            // 3.
            answer[i] = subMultiple * inputMultiple;
        }

        return answer;
    }

    /**
     * 1. Calculate the left-side product
     * 2. Obtain the right-side product
     * 3. Multiply the two products
     */
    public int[] productExceptSelf3(int[] nums) {

        int[] answer = new int[nums.length];

        int cumulativeMultiple = 1;

        // 1
        for (int i = 0; i < nums.length; i++) {
            answer[i] = cumulativeMultiple;
            cumulativeMultiple *= nums[i];
        }

        // 2 & 3
        cumulativeMultiple = 1;
        for (int j = nums.length - 1; j >= 0; j--) {
            answer[j] *= cumulativeMultiple;
            cumulativeMultiple *= nums[j];
        }

        return answer;
    }

}
