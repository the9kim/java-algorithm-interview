package org.javaalgorithminterview.ch14_tree;

public class P56_1_Binary_Search_Tree_to_Greater_Sum_Tree {
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

    int prevSum = 0;

    /**
     * Recursive in-order traversal
     *
     * 1. Move to the rightmost node in the tree.
     * 2. Calculate accumulated sum of bigger node values and update the current node's value to the sum
     * 3. Move to the left child node and return to the process 1.
     */
    public TreeNode bstToGst(TreeNode root) {

        if (root == null) {
            return null;
        }

        // 1
        bstToGst(root.right);

        // 2
        prevSum = prevSum + root.val;
        root.val = prevSum;

        // 3
        bstToGst(root.left);

        return root;
    }
}
