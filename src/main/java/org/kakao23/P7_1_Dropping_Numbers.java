package org.kakao23;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P7_1_Dropping_Numbers {

    /**
     * 1. Create a graph
     * 2. Calculate the Minimum count of numbers dropped onto each leaf node
     * 3. Find the combination of numbers in alphabetical order based on each minimum count
     */

    public int[] solution(int[][] edges, int[] target) {
        int N = edges.length + 1;
        int leafCount = 0;

        int[] visitCnt = new int[N];
        int[] dropCnt = new int[N];
        boolean[] checked = new boolean[N];
        List<Integer> leaves = new ArrayList<>();

        // 1.
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int from = edge[0] - 1;
            int to = edge[1] - 1;
            graph.putIfAbsent(from, new ArrayList<>());
            graph.get(from).add(to);
        }

        for (List<Integer> value : graph.values()) {
            Collections.sort(value);
        }

        // 2.
        for (int node = 0; node < N; node++) {
            if (!graph.containsKey(node) && target[node] > 0) {
                leafCount++;
            }
        }

        while (leafCount > 0) {
            int node = 0;

            while (graph.containsKey(node)) {
                int order = visitCnt[node]++ % graph.get(node).size();
                node = graph.get(node).get(order);
            }
            dropCnt[node]++;
            leaves.add(node);

            if (dropCnt[node] > target[node]) {
                return new int[]{-1};
            }
            if (!checked[node] && target[node] <= dropCnt[node] * 3) {
                checked[node] = true;
                leafCount--;
            }
        }

        // 3.
        List<Integer> result = new ArrayList<>();

        for (Integer leaf : leaves) {
            dropCnt[leaf]--;
            for (int num = 1; num <= 3; num++) {
                if (dropCnt[leaf] <= target[leaf] - num && target[leaf] - num <= dropCnt[leaf] * 3) {
                    result.add(num);
                    target[leaf] -= num;
                    break;
                }
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
