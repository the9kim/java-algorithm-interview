package org.javaalgorithminterview.ch12_graph;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import java.util.Deque;
import java.util.ArrayDeque;

public class DFS {

    private Map<Integer, List<Integer>> graph;

    public DFS(Map<Integer, List<Integer>> graph) {
        this.graph = graph;
    }

    public List<Integer> recursiveDFS(Integer v, List<Integer> discovered) {

        discovered.add(v);

        for (int p : graph.get(v)) {
            if (!discovered.contains(p)) {
                discovered = recursiveDFS(p, discovered);
            }
        }
        return discovered;
    }

    public List<Integer> iterativeDFS(Integer v) {

        List<Integer> discovered = new ArrayList<>();

        Deque<Integer> stack = new ArrayDeque<>();

        stack.push(v);

        while (!stack.isEmpty()) {
            Integer top = stack.pop();
            if (!discovered.contains(top)) {
                discovered.add(top);
                for (Integer p : graph.get(top)) {
                    stack.push(p);
                }
            }
        }
        return discovered;
    }


}
