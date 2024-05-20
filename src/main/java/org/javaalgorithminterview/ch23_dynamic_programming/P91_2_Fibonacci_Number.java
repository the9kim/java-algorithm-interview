package org.javaalgorithminterview.ch23_dynamic_programming;

import java.util.ArrayList;
import java.util.List;

public class P91_2_Fibonacci_Number {

    /**
     * Brute Force
     */
    public int fib(int n) {
        if (n < 2) {
            return n;
        }

        return fib(n - 1) + fib(n - 2);
    }
}
