package org.javaalgorithminterview.ch13_shortest_path;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;


/**
 * This solution only can handle the case when the answer route is the most cost efficient,
 * which can't solve the test-case3
 */
public class P45_1_Cheapest_Flights_Within_K_Stops {

    /**
     * 1. Create a graph.
     * 2. Search for the Cheapest route using BFS.
     * 3. Check the condition of limited stops.
     * 4, Return the Minimum price within K stops.
     */

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        // 1
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();

        for (int[] flight : flights) {
            graph.putIfAbsent(flight[0], new HashMap<>());
            graph.get(flight[0]).put(flight[1], flight[2]);
        }

        // 2
        int count = k;

        Queue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(Map.Entry.comparingByValue());
        pq.add(new AbstractMap.SimpleEntry<>(src, 0));

        Map<Integer, Integer> dist = new HashMap<>();

        while (!pq.isEmpty()) {
            Map.Entry<Integer, Integer> node = pq.poll();
            Integer nodeId = node.getKey();
            Integer nodePrice = node.getValue();

            if (dist.containsKey(nodeId)) {
                continue;
            }
            dist.put(nodeId, nodePrice);

            // 3
            if (count == 0 && graph.containsKey(nodeId) && graph.get(nodeId).containsKey(dst)) {
                Integer newPrice = nodePrice + graph.get(nodeId).get(dst);
                dist.put(dst, newPrice);
            } else if (count == 0
                    && graph.containsKey(nodeId)
                    && !dist.containsKey(dst)
                    && !graph.get(nodeId).containsKey(dst)) {
                return -1;
            }

            if (graph.containsKey(nodeId)) {
                for (Map.Entry<Integer, Integer> next : graph.get(nodeId).entrySet()) {
                    int newPrice = nodePrice + next.getValue();
                    pq.add(new AbstractMap.SimpleEntry<>(next.getKey(), newPrice));
                }
            }
            count--;
        }

        if (dist.containsKey(dst)) {
            return dist.get(dst);
        }
        return -1;

    }
}
