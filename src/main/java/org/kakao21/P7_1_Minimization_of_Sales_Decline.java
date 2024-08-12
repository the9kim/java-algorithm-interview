package org.kakao21;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P7_1_Minimization_of_Sales_Decline {

    Map<Integer, List<Integer>> graph = new HashMap<>();
    int[] sales;
    int[][] cost;

    /**
     * 1. Create a graph
     * 2. Find an optimal combination using DP and Tree Traversal
     */
    public int solution(int[] sales, int[][] links) {
        this.sales = sales;
        cost = new int[sales.length][2];

        // 1
        for (int[] link : links) {
            int from = link[0] - 1;
            int to = link[1] - 1;
            graph.putIfAbsent(from, new ArrayList<>());
            graph.get(from).add(to);
        }

        // 2.
        traverse(0);

        return Math.min(cost[0][0], cost[0][1]);

    }

    public void traverse(int node) {
        cost[node][0] = 0;
        cost[node][1] = sales[node];

        if (!graph.containsKey(node)) {
            return;
        }
        int minChild = Integer.MAX_VALUE;

        for (Integer child : graph.get(node)) {
            traverse(child);


            if (cost[child][0] < cost[child][1]) {
                cost[node][0] += cost[child][0];
                cost[node][1] += cost[child][0];
                minChild = Math.min(minChild, cost[child][1] - cost[child][0]);
            } else {
                cost[node][0] += cost[child][1];
                cost[node][1] += cost[child][1];
                minChild = 0;
            }
        }
        cost[node][0] += minChild;
    }

}
