package org.javaalgorithminterview.ch23_dynamic_programming;

public class P91_4_Fibonacci_Number {

    /**
     * Optimize space complexity
     */
    public int fib(int n) {
        int x = 0, y = 1;

        for (int i = 0; i < n; i++) {
            int z = x + y;
            x = y;
            y = z;
        }
        return x;
    }
}
