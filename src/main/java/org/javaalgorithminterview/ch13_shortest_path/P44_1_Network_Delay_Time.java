package org.javaalgorithminterview.ch13_shortest_path;

import java.util.AbstractMap;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class P44_1_Network_Delay_Time {

    /**
     * 1. Create a graph.
     * 2. Insert the graph's values into a Priority queue with an accumulated time and Update a visited route.
     * 3. Check if all routes have been found.
     */
    public int networkDelayTime(int[][] times, int n, int k) {

        // 1
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();

        for (int[] time : times) {
            graph.putIfAbsent(time[0], new HashMap<>());
            graph.get(time[0]).put(time[1], time[2]);
        }

        // 2
        Queue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(Map.Entry.comparingByValue());
        pq.add(new AbstractMap.SimpleEntry<>(k, 0));

        Map<Integer, Integer> dist = new HashMap<>();

        while (!pq.isEmpty()) {
            Map.Entry<Integer, Integer> temp = pq.poll();
            Integer key = temp.getKey();
            Integer value = temp.getValue();

            if (!dist.containsKey(key)) {
                dist.put(key, value);

                if (graph.containsKey(key)) {
                    for (Map.Entry<Integer, Integer> entry : graph.get(key).entrySet()) {
                        int newTime = value + entry.getValue();
                        pq.add(new AbstractMap.SimpleEntry<>(entry.getKey(), newTime));
                    }
                }
            }
        }

        // 3
        if (dist.size() == n) {
            Integer max = Collections.max(dist.values());
            return max;
        }
        return -1;

    }
}
