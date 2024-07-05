package org.kakao22;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class P5_1_Sheep_and_Wolves {
    static class Node {
        int index;
        int sheep;
        int wolves;
        List<Integer> nodes;

        public Node(int index, int sheep, int wolves, List<Integer> nodes) {
            this.index = index;
            this.sheep = sheep;
            this.wolves = wolves;
            this.nodes = nodes;
        }
    }

    Map<Integer, List<Integer>> graph = new HashMap<>();
    int answer = 1;

    /**
     * 1. Create a graph
     * 2. Find the number of sheep using iterative BFS
     */
    public int solution(int[] info, int[][] edges) {

        // 1.
        for (int[] edge : edges) {
            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.get(edge[0]).add(edge[1]);
        }

        // 2.
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 1, 0, graph.get(0)));

        while (!q.isEmpty()) {
            Node node = q.poll();

            for (int child : node.nodes) {
                int nextSheep = info[child] == 0 ? node.sheep + 1 : node.sheep;
                int newWolves = info[child] == 1 ? node.wolves + 1 : node.wolves;

                if (nextSheep > newWolves) {
                    answer = Math.max(answer, nextSheep);

                    List<Integer> newNodes = new ArrayList<>(node.nodes);
                    newNodes.remove((Integer) child);
                    if (graph.get(child) != null) {
                        newNodes.addAll(graph.get(child));
                    }

                    q.add(new Node(child, nextSheep, newWolves, newNodes));
                }
            }
        }
        return answer;
    }
}
