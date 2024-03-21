package org.javaalgorithminterview.ch14_tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P54_2_Minimum_Height_Trees {

    /**
     * 1. Create a bidirectional graph.
     * 2. Find leaves of the graph.
     * 3. Keep removing the leaves Until the top level nodes remain.
     * 4. Return the MHTs.
     */
    public List<Integer> findMinimumHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return List.of(0);
        }

        // 1.
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.putIfAbsent(edge[1], new ArrayList<>());
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        // 2.
        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (graph.get(i).size() == 1) {
                leaves.add(i);
            }
        }

        // 3.
        while (n > 2) {
            n -= leaves.size();

            List<Integer> newLeaves = new ArrayList<>();

            for (Integer leaf : leaves) {
                Integer neighbor = graph.get(leaf).get(0);
                graph.get(neighbor).remove((Object) leaf);
                if (graph.get(neighbor).size() == 1) {
                    newLeaves.add(neighbor);
                }
            }

            leaves = newLeaves;
        }

        // 4.
        return leaves;
    }
}
