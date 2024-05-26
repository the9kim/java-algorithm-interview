package org.javaalgorithminterview.ch21_greedy_algorithm;

import java.util.Arrays;

public class P88_2_Assign_Cookies {
    /**
     * The book solution
     */
    public int findContentChildren(int[] g, int[] s) {
        // 1
        Arrays.sort(g);
        Arrays.sort(s);

        // 2
        int child = 0;
        int cookie = 0;

        while (child < g.length && cookie < s.length) {
            if (g[child] <= s[cookie]) {
                child++;
            }
            cookie++;
        }
        return child;
    }
}
