package org.javaalgorithminterview.ch13_shortest_path;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * With this solution, Because cyclic composition occurs, It can't handle the test-case-1
 */
public class P45_2_Cheapest_Flights_Within_K_Stops {

    static class Node implements Comparable<Node> {
        int id;
        int price;
        int level;

        public Node(int id, int price) {
            this.id = id;
            this.price = price;
        }

        public Node(int id, int price, int level) {
            this.id = id;
            this.price = price;
            this.level = level;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.price, other.price);
        }

        public void setLevel(int level) {
            this.level = level;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "id=" + id +
                    ", price=" + price +
                    ", level=" + level +
                    '}';
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
        Map<Integer, List<Node>> graph = new HashMap<>();

        for (int[] flight : flights) {
            graph.putIfAbsent(flight[0], new ArrayList<>());
            graph.get(flight[0]).add(new Node(flight[1], flight[2]));
        }

        // 2
        Queue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(src, 0, 0));

        List<Node> dist = new ArrayList<>();

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            dist.add(node);

            if (graph.containsKey(node.id)) {
                for (Node next : graph.get(node.id)) {
                    next.setLevel(node.level + 1);
                    Integer newPrice = node.price + next.price;
                    // 3
                    if (next.id != dst && next.level > k) {
                        continue;
                    }
                    pq.add(new Node(next.id, newPrice, node.level + 1));
                }
            }
        }

        // 4
        Node minNode = dist.stream()
                .filter(node -> node.id == dst && node.level <= k + 1)
                .min(Comparator.comparingInt(node -> node.price))
                .orElse(null);

        if (minNode == null) {
            return -1;
        }
        return minNode.price;
    }
}
