package org.javaalgorithminterview.ch14_tree;


import java.util.AbstractMap;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

/**
 * The solution using Iterative DFS
 */
public class P47_2_Maximum_Depth_of_Binary_Tree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(){}

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int maxDepth(TreeNode root) {

        int maxDepth = 0;

        Deque<Map.Entry<TreeNode, Integer>> stack = new ArrayDeque<>();

        stack.push(new AbstractMap.SimpleEntry<>(root, 1));

        while (!stack.isEmpty()) {
            Map.Entry<TreeNode, Integer> parentMap = stack.pop();
            TreeNode parent = parentMap.getKey();
            Integer depth = parentMap.getValue();

            if (parentMap.getKey() != null) {
                maxDepth = Math.max(maxDepth, depth);

                Integer newDepth = depth + 1;
                stack.push(new AbstractMap.SimpleEntry<> (parent.left, newDepth));
                stack.push(new AbstractMap.SimpleEntry<> (parent.right, newDepth));
            }
        }

        return maxDepth;
    }
}
