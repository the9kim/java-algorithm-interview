package org.javaalgorithminterview.ch23_dynamic_programming;

import java.util.ArrayList;
import java.util.List;

public class P91_1_Fibonacci_Number {

    /**
     * Tabulation
     */
    public int fib(int n) {
        int[] dp = new int[31];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}
