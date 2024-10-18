package org.kakao22;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class P5_2_Sheep_and_Wolves {

    static class Node {
        int sheeps;
        int wolves;
        int idx;
        List<Integer> children;

        public Node(int sheeps, int wolves, int idx, List<Integer> children) {
            this.sheeps = sheeps;
            this.wolves = wolves;
            this.idx = idx;
            this.children = children;
        }
    }

    int maxSheeps = 1;

    public int solution(int[] info, int[][] edges) {
        Map<Integer, List<Integer>> graph = createGraph(edges);

        bfs(info, graph);

        return maxSheeps;

    }

    private void bfs(int[] info, Map<Integer, List<Integer>> graph) {
        Queue<Node> q = new LinkedList<>();

        q.add(new Node(1, 0, 0, new ArrayList<>(graph.get(0))));

        while (!q.isEmpty()) {
            Node node = q.poll();

            for (Integer child : node.children) {
                int nextSheeps = node.sheeps + (info[child] == 0 ? 1 : 0);
                int nextWolves = node.wolves + (info[child] == 1 ? 1 : 0);

                if (nextSheeps > nextWolves) {

                    maxSheeps = Math.max(maxSheeps, nextSheeps);

                    List<Integer> newChildren = new ArrayList<>(node.children);

                    newChildren.remove(child);

                    if (graph.containsKey(child)) {
                        newChildren.addAll(graph.get(child));
                    }

                    q.add(new Node(nextSheeps, nextWolves, child, newChildren));
                }
            }
        }
    }


    private Map<Integer, List<Integer>> createGraph(int[][] edges) {

        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int[] e : edges) {
            graph.putIfAbsent(e[0], new ArrayList<>());
            graph.get(e[0]).add(e[1]);
        }

        return graph;
    }
}
