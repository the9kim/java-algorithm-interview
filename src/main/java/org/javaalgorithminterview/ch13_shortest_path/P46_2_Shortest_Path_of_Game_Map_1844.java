package org.javaalgorithminterview.ch13_shortest_path;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class P46_2_Shortest_Path_of_Game_Map_1844 {

    static class Node {
        int row;
        int col;
        int distance;

        public Node(int row, int col, int distance) {
            this.row = row;
            this.col = col;
            this.distance = distance;
        }

//        @Override
//        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (o == null || getClass() != o.getClass()) return false;
//            Node node = (Node) o;
//            return row == node.row && col == node.col;
//        }
//
//        @Override
//        public int hashCode() {
//            return Objects.hash(row, col);
//        }
    }

    Queue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.distance));

//    public void findRoute(int[][] maps, Node node) {
//        if (node.row < maps.length
//                && node.col < maps[0].length
//                && node.row >= 0
//                && node.col >= 0
//                && maps[node.row][node.col] == 1
//                && !pq.contains(node)
//        ) {
//            pq.add(node);
//        }
//    }

    public void findRoute(int[][] maps, Node node) {
        if (node.row < maps.length
                && node.col < maps[0].length
                && node.row >= 0
                && node.col >= 0
                && maps[node.row][node.col] == 1
        ) {
            maps[node.row][node.col] = 0;
            pq.add(node);
        }
    }


    public int solution(int[][] maps) {

        Map<Integer, Node> dist = new LinkedHashMap<>();

        pq.add(new Node(0, 0, 1));

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if (!dist.containsKey(node.row * 1000 + node.col)) {
                dist.put(node.row * 1000 + node.col, node);

                findRoute(maps, new Node(node.row, node.col + 1, node.distance + 1));
                findRoute(maps, new Node(node.row + 1, node.col, node.distance + 1));
                findRoute(maps, new Node(node.row - 1, node.col, node.distance + 1));
                findRoute(maps, new Node(node.row, node.col - 1, node.distance + 1));
            }
        }

        if (dist.containsKey((maps.length - 1) * 1000 + (maps[0].length - 1))) {
            return dist.get((maps.length - 1) * 1000 + (maps[0].length - 1)).distance;
        }
        return -1;
    }
}
