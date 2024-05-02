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
            // Add an Element onto the window
            window.add(nums[i]);

            if (i < k - 1) {
                continue;
            }

            // Update the max value or Calculate a new one
            if (max == Integer.MIN_VALUE) {
                max = window.stream().max(Integer::compareTo).get();
            } else if (nums[i] > max) {
                max = nums[i];
            }

            // Add the max value onto the answer
            answer.add(max);

            // Remove an element which is out of a range and initialize a max value
            if (window.poll() == max) {
                max = Integer.MIN_VALUE;
            }
        }
        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
