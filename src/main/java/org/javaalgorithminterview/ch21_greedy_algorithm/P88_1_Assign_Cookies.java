package org.javaalgorithminterview.ch21_greedy_algorithm;

import java.util.Arrays;

public class P88_1_Assign_Cookies {
    /**
     * 1. Sort the two input arrays
     * 2. Compare the children array with the cookies array
     */
    public int findContentChildren(int[] g, int[] s) {
        // 1
        Arrays.sort(g);
        Arrays.sort(s);

        // 2
        int count = 0;
        int cookieIdx = 0;

        for (int child : g) {
            while (cookieIdx < s.length && child > s[cookieIdx]) {
                cookieIdx++;

            }
            if (cookieIdx < s.length) {
                count++;
                cookieIdx++;
            }
        }
        return count;
    }
}
