package org.javaalgorithminterview.ch14_tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class P54_1_Minimum_Height_Trees {

    static class TreeNode {
        int val;
        List<TreeNode> children = new ArrayList<>();

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, List<TreeNode> children) {
            this.val = val;
            this.children = children;
        }
    }

    /**
     * 1. Make a bidirectional graph
     * 2. Create trees
     * 3. Calculate the heights of trees
     * 4. Find minimum height trees
     */
    public List<Integer> findMinimumHeightTrees(int n, int[][] edges) {

        // 1 Make Tree Bidirectional graph
        Map<Integer, List<Integer>> edgeMap = new HashMap<>();
        for (int[] edge : edges) {
            edgeMap.putIfAbsent(edge[0], new ArrayList<>());
            edgeMap.putIfAbsent(edge[1], new ArrayList<>());
            edgeMap.get(edge[0]).add(edge[1]);
            edgeMap.get(edge[1]).add(edge[0]);
        }

        int minHeight = Integer.MAX_VALUE;
        Map<Integer, Integer> heightMap = new HashMap<>();


        for (int i = 0; i < n; i++) {
            // 2
            TreeNode root = createTree(edgeMap, i, null);
            // 3
            int height = calculateHeight(root);
            minHeight = Math.min(minHeight, height);
            heightMap.put(i, height);
        }

        // 4
        final int finalHeight = minHeight;
        return heightMap.entrySet().stream()
                .filter(entry -> entry.getValue() == finalHeight)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public TreeNode createTree(Map<Integer, List<Integer>> edgeMap, Integer nodeVal, Integer parentVal) {

        // Create a TreeNode
        TreeNode root = new TreeNode(nodeVal);

        // Create children
        if (edgeMap.containsKey(nodeVal)) {
            for (Integer child : edgeMap.get(nodeVal)) {
                // Check if a child is same with a parent
                if (parentVal == null || !parentVal.equals(child)) {
                    root.children.add(createTree(edgeMap, child, nodeVal));
                }
            }
        }
        return root;
    }

    public int calculateHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        if (node.children.isEmpty()) {
            return 0;
        }

        List<Integer> heights = new ArrayList<>();
        for (TreeNode child : node.children) {
            heights.add(calculateHeight(child));
        }

        return Collections.max(heights) + 1;
    }
}
