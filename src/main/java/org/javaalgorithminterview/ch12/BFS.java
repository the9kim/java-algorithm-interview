package org.javaalgorithminterview.ch12;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;

public class BFS {
    private Map<Integer, List<Integer>> graph;

    public BFS(Map<Integer, List<Integer>> graph) {
        this.graph = graph;
    }

    public List<Integer> iterativeBFS(Integer v) {
        List<Integer> discovered = new ArrayList<>();

        Queue<Integer> path = new LinkedList<>();

        path.add(v);
        discovered.add(v);

        while (!path.isEmpty()) {
            Integer node = path.poll();

            for (Integer p : graph.get(node)) {
                if (!discovered.contains(p)) {
                    path.add(p);
                    discovered.add(p);
                }
            }
        }

        return discovered;
    }
}
