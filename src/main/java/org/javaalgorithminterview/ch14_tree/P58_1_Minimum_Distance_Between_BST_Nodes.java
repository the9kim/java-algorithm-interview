package org.javaalgorithminterview.ch14_tree;

public class P58_1_Minimum_Distance_Between_BST_Nodes {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int dfs(TreeNode node, int rootVal) {
        int diff = Integer.MAX_VALUE;

        if (node.val != rootVal) {
            diff = Math.abs(node.val - rootVal);
        }

        if (node.right != null && node.val <= rootVal) {
            diff = Math.min(diff, dfs(node.right, rootVal));
        }
        if (node.left != null && node.val >= rootVal) {
            diff = Math.min(diff, dfs(node.left, rootVal));
        }
        return diff;
    }

    /**
     * 1. Calculate the minimum distance between the root node and its children nodes using recursive DFS with pruning.
     * 2. Convert the root node to its child node, then calculate and update the minimum distance using recursive DFS.
     */
    public int minDiffBST(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int minDiff = Integer.MAX_VALUE;

        minDiff = Math.min(minDiff, dfs(root, root.val));

        if (root.left != null) {
            minDiff = Math.min(minDiff, minDiffBST(root.left));
        }

        if (root.right != null) {
            minDiff = Math.min(minDiff, minDiffBST(root.right));
        }

        return minDiff;
    }
}
