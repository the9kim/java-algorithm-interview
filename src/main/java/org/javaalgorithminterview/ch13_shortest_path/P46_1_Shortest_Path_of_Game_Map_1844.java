package org.javaalgorithminterview.ch13_shortest_path;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class P46_1_Shortest_Path_of_Game_Map_1844 {

    public int solution(int[][] maps) {
        Map<List<Integer>, List<List<Integer>>> graph = new HashMap<>();

        for (int row = 0; row < maps.length; row++) {
            for (int col = 0; col < maps[0].length; col++) {
                if (maps[row][col] == 1) {
                    graph.putIfAbsent(List.of(row, col), new ArrayList<>());
                    List<List<Integer>> neighbors = graph.get(List.of(row, col));

                    if (col + 1 < maps[0].length && maps[row][col + 1] == 1) {
                        neighbors.add(List.of(row, col + 1));
                    }
                    if (row + 1 < maps.length && maps[row + 1][col] == 1) {
                        neighbors.add(List.of(row + 1, col));
                    }
                    if (row - 1 >= 0 && maps[row - 1][col] == 1) {
                        neighbors.add(List.of(row - 1, col));
                    }
                    if (col - 1 >= 0 && maps[row][col - 1] == 1) {
                        neighbors.add(List.of(row, col - 1));
                    }
                }
            }
        }

        Queue<List<Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.get(2)));
        pq.add(List.of(0, 0, 1));

        Map<List<Integer>, Integer> dist = new HashMap<>();

        while (!pq.isEmpty()) {
            List<Integer> node = pq.poll();
            List<Integer> nodeId = List.of(node.get(0), node.get(1));
            Integer nodeDistance = node.get(2);

            if (!dist.containsKey(nodeId)) {
                dist.put(nodeId, nodeDistance);

                if (graph.containsKey(nodeId)) {
                    for (List<Integer> nextId : graph.get(nodeId)) {
                        Integer newDistance = nodeDistance + 1;
                        pq.add(List.of(nextId.get(0), nextId.get(1), newDistance));
                    }
                }
            }
        }

        if (dist.containsKey(List.of(maps.length - 1, maps[0].length - 1))) {
            return dist.get(List.of(maps.length - 1, maps[0].length - 1));
        }

        return -1;
    }

    public Map<List<Integer>, List<List<Integer>>> createGraph(int[][] maps) {

        Map<List<Integer>, List<List<Integer>>> graph = new HashMap<>();

        for (int row = 0; row < maps.length; row++) {
            for (int col = 0; col < maps[0].length; col++) {
                if (maps[row][col] == 1) {
                    graph.putIfAbsent(List.of(row, col), new ArrayList<>());
                    List<List<Integer>> neighbors = graph.get(List.of(row, col));

                    if (col + 1 < maps[0].length && maps[row][col + 1] == 1) {
                        neighbors.add(List.of(row, col + 1));
                    }
                    if (row + 1 < maps.length && maps[row + 1][col] == 1) {
                        neighbors.add(List.of(row + 1, col));
                    }
                    if (row - 1 >= 0 && maps[row - 1][col] == 1) {
                        neighbors.add(List.of(row - 1, col));
                    }
                    if (col - 1 >= 0 && maps[row][col - 1] == 1) {
                        neighbors.add(List.of(row, col - 1));
                    }
                }
            }
        }
        return graph;
    }


    public int searchRoute(Map<List<Integer>, List<List<Integer>>> graph, int[][] maps) {

        Queue<List<Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.get(2)));
        pq.add(List.of(0, 0, 1));

        Map<List<Integer>, Integer> dist = new HashMap<>();

        while (!pq.isEmpty()) {
            List<Integer> node = pq.poll();
            List<Integer> nodeId = List.of(node.get(0), node.get(1));
            Integer nodeDistance = node.get(2);

            if (!dist.containsKey(nodeId)) {
                dist.put(nodeId, nodeDistance);

                if (graph.containsKey(nodeId)) {
                    for (List<Integer> nextId : graph.get(nodeId)) {
                        if (!nodeId.equals(nextId)) {
                            Integer newDistance = nodeDistance + 1;
                            pq.add(List.of(nextId.get(0), nextId.get(1), newDistance));
                        }
                    }
                }
            }
        }

        if (dist.containsKey(List.of(maps.length - 1, maps[0].length - 1))) {
            return dist.get(List.of(maps.length - 1, maps[0].length - 1));
        }
        return -1;
    }
}
