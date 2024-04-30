package org.javaalgorithminterview.ch20_sliding_window;

import java.util.Arrays;

public class P81_1_Sliding_Window_Maximum {

    /**
     * Time exceeded
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] answer = new int[nums.length - k + 1];

        int right = k;
        int max = Integer.MIN_VALUE;

        for (int left = 0; left < nums.length - k + 1; left++) {
            if (nums[right - 1] > max || (left > 0 && nums[left - 1] == max)) {
                max = getMax(nums, left, right);
            }
            nums[left] = max;
            right++;
        }
        return answer;
    }

    private int getMax(int[] nums, int left, int right) {
        int[] sub = Arrays.copyOfRange(nums, left, right);
        return Arrays.stream(sub)
                .max()
                .getAsInt();
    }
}
