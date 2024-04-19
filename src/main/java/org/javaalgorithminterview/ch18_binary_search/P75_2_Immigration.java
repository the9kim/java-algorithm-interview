package org.javaalgorithminterview.ch18_binary_search;

import java.util.Arrays;

/**
 * The book solution using Binary Search
 */
public class P75_2_Immigration {

    public long solution(int n, int[] times) {
        long answer = 0;

        long left = 1;
        long right = Arrays.stream(times).max().getAsInt() * n;

        long mid = right;

        while (left <= right) {
            long calcN = 0;

            for (long time : times) {
                calcN += (mid / time);
            }

            if (calcN >= n) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }

            mid = left + (right - left) / 2;
        }
        return answer;
    }
}
