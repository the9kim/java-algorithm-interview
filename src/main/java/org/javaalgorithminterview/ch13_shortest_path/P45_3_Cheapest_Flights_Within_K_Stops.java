package org.javaalgorithminterview.ch13_shortest_path;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * This solution search the same route repeatedly, so Time-exceeded happens
 */
public class P45_3_Cheapest_Flights_Within_K_Stops {

    static class Node {
        int id;
        int price;
        int level;

        public Node(int id, int price, int level) {
            this.id = id;
            this.price = price;
            this.level = level;
        }
    }

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
        Queue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.price));
        pq.add(new Node(src, 0, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if (node.id == dst) {
                return node.price;
            }

            if (node.level > k) {
                continue;
            }

            List<int[]> neighbors = graph.getOrDefault(node.id, new ArrayList<>());
            for (int[] neighbor : neighbors) {
                int nextId = neighbor[0];
                int nextPrice = node.price + neighbor[1];
                int nextLevel = node.level + 1;
                // 3
                pq.offer(new Node(nextId, nextPrice, nextLevel));
            }
        }

        // 4
        return -1;
    }
}
