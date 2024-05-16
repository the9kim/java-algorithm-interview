package org.javaalgorithminterview.ch21_greedy_algorithm;

public class P87_1_Gas_Station {
    /**
     * Brute Force - Time exceeded
     *
     * 1. Find an index that the gas is bigger than the cost
     * 2. Travel from the index to the starting point
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {

        for (int i = 0; i < gas.length; i++) {
            if (gas[i] >= cost[i]) {
                int remained = 0;
                for (int j = i; j < i + gas.length + 1; j++) {
                    int idx = j % gas.length;
                    remained = gas[idx] - cost[idx] + remained;
                    if (remained < 0) {
                        break;
                    } else if (remained >= 0 && j == i + gas.length) {
                        return i;
                    }
                }
            }
        }
        return -1;
    }
}
