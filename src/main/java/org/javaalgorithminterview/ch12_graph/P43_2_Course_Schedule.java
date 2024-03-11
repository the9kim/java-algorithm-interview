package org.javaalgorithminterview.ch12_graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * The book solution.
 *
 * checking cyclic composition using DFS.
 * But, time limit exceeded.
 */
public class P43_2_Course_Schedule {

    public boolean dfs(
            Map<Integer, List<Integer>> graph,
            List<Integer> path,
            Integer finish) {

        if (path.contains(finish)) {
            return false;
        }

        if (graph.containsKey(finish)) {
            path.add(finish);
            for (Integer from : graph.get(finish)) {
                if (!dfs(graph, path, from)) {
                    return false;
                }
            }
            path.remove(finish);
        }
        return true;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int[] pre : prerequisites) {
            graph.putIfAbsent(pre[0], new ArrayList<>());
            graph.get(pre[0]).add(pre[1]);
        }

        List<Integer> path = new ArrayList<>();

        for (Integer finish : graph.keySet()) {
            if (!dfs(graph, path, finish)) {
                return false;
            }
        }
        return true;
    }
}
