package org.javaalgorithminterview.ch21_greedy_algorithm;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class P86_1_Task_Scheduler {
    /**
     * 1. Calculate a counter map
     * 2. Calculate the minimum number of intervals
     */
    public int leastInterval(char[] tasks, int n) {

        // 1.
        Map<Character, Integer> counter = new HashMap<>();
        for (char c : tasks) {
            counter.put(c, counter.getOrDefault(c, 0) + 1);
        }

        int numOfChar = counter.keySet().size();
        int maxValue = Collections.max(counter.values());
        int maxCount = 0;
        for (Map.Entry<Character, Integer> entry : counter.entrySet()) {
            if (entry.getValue() == maxValue) {
                maxCount++;
            }
        }

        // 2.
        if (numOfChar >= n + 1 && (maxValue - 1) * (n + 1) + (maxCount) <= tasks.length ) {
            return tasks.length;
        } else {
            return (maxValue - 1) * (n + 1) + (maxCount);
        }
    }
}
