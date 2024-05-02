package org.javaalgorithminterview.ch18_binary_search;

import java.util.Arrays;

/**
 * The book solution using Binary Search
 */
public class P75_2_Immigration {

    public long solution(int n, int[] times) {
        long answer = 0;

        long left = 1;
        long right = (long) Arrays.stream(times).max().getAsInt() * n;

        long mid = right;

        // Why should this comparison operation contain equal(=)?
        while (left <= right) {
            long calcN = 0;

            for (long time : times) {
                calcN += (mid / time);
            }

            // The answer continue to converge until the remainder is zero when dividing the total time by a unit time
            if (calcN >= n) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            // Why isn't the logic to calculate mid at the beginning?
            mid = left + (right - left) / 2;
        }
        return answer;
    }
}
