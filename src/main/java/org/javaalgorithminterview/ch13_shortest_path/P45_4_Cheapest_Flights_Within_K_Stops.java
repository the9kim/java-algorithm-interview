package org.javaalgorithminterview.ch13_shortest_path;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * The solution that improve time efficiency
 */

public class P45_4_Cheapest_Flights_Within_K_Stops {

    /**
     * 1. Create a graph.
     * 2. Search for the Cheapest route using BFS.
     * 3. Check the condition of limited stops.
     * 4, Return the Minimum price within K stops.
     */
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        // 1
        Map<Integer, List<int[]>> graph = new HashMap<>();

        for (int[] flight : flights) {
            graph.putIfAbsent(flight[0], new ArrayList<>());
            graph.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }

        // 2
        Map<Integer, Integer> visited = new HashMap<>();

        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node[1]));
        pq.offer(new int[]{src, 0, 0});

        while (!pq.isEmpty()) {
            int[] node = pq.poll();

            if (node[0] == dst) {
                return node[1];
            }

            if (node[2] > k) {
                continue;
            }

//            Why it is not working?
//            if (visited.containsKey(node[0]) && node[2] > visited.get(node[0])) {
//                continue;
//            }

            visited.put(node[0], node[2]);

            List<int[]> neighbors = graph.getOrDefault(node[0], new ArrayList<>());
            for (int[] neighbor : neighbors) {
                int nextId = neighbor[0];
                int nextPrice = node[1] + neighbor[1];
                int nextLevel = node[2] + 1;
                if (visited.containsKey(nextId) && visited.get(nextId) < nextLevel) {
                    continue;
                }
                pq.offer(new int[]{nextId, nextPrice, nextLevel});
                // 3
            }
        }

        // 4
        return -1;
    }
}
