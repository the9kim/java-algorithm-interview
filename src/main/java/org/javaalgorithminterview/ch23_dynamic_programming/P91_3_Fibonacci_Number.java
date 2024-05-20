package org.javaalgorithminterview.ch23_dynamic_programming;

import java.util.ArrayList;
import java.util.List;

public class P91_3_Fibonacci_Number {

    private int[] dp = new int[31];

    /**
     * Memoization
     */
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        if (dp[n] != 0) {
            return dp[n];
        }

        dp[n] = fib(n - 1) + fib(n - 2);
        return dp[n];
    }
}
