package org.javaalgorithminterview.ch20_sliding_window;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P81_2_Sliding_Window_Maximum {

    /**
     * The book's solution that optimizes using a queue.
     */
    public int[] maxSlidingWindow(int[] nums, int k) {

        List<Integer> answer = new ArrayList<>();

        Queue<Integer> window = new LinkedList<>();

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            window.add(nums[i]);

            if (i < k - 1) {
                continue;
            }

            if (max == Integer.MIN_VALUE) {
                max = window.stream().max(Integer::compareTo).get();
            } else if (nums[i] > max) {
                max = nums[i];
            }

            answer.add(max);

            if (window.poll() == max) {
                max = Integer.MIN_VALUE;
            }
        }
        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
