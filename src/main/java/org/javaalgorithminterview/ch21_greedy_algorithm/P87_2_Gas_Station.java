package org.javaalgorithminterview.ch21_greedy_algorithm;

import java.util.Arrays;

public class P87_2_Gas_Station {
    /**
     * The book solution
     *
     * 1. Check if the cost is greater than the gas amount
     * 2. Find the starting point
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (Arrays.stream(gas).sum() < Arrays.stream(cost).sum()) {
            return -1;
        }

        int fuel = 0;
        int start = 0;

        for (int i = 0; i < gas.length; i++) {
            if (fuel + gas[i] - cost[i] < 0) {
                start = i + 1;
                fuel = 0;
            } else {
                fuel += gas[i] - cost[i];
            }
        }
        return start;
    }
}
