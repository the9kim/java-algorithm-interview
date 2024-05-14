package org.javaalgorithminterview.ch21_greedy_algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class P86_2_Task_Scheduler {
    /**
     * The book solution
     *
     * 1. Calculate the frequency of alphabets using primitive type
     * 2. Insert frequency values into a Priority Queue
     * 2. calculate the minimum number of intervals
     */
    public int leastInterval(char[] tasks, int n) {
        // 1
        int[] freq = new int[26];

        for (char c : tasks) {
            freq[c - 'A']++;
        }

        // 2.
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for (int f : freq) {
            if (f != 0) {
                pq.add(f);
            }
        }

        // 3.
        int answer = 0;
        while (true) {
            int interval = 0;
            List<Integer> elems = new ArrayList<>();

            while (!pq.isEmpty()) {
                Integer e = pq.poll();

                if (n + 1 > interval) {
                    interval++;
                    answer++;
                    if (e > 1) {
                        elems.add(e - 1);
                    }
                } else {
                    elems.add(e);
                }
            }

            if (elems.isEmpty()) {
                break;
            }
            pq.addAll(elems);
            answer += n + 1 - interval;
        }

        return answer;
    }
}
