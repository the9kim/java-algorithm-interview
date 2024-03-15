package org.javaalgorithminterview.ch14_tree;

/**
 * State Accumulation Tree DFS
 *
 * 1. Calculating the maximum dept of each of children nodes.
 * 2. Updating the maximum diameter
 */
public class P48_1_Diameter_of_Binary_Tree {

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

    Integer diameter = 0;

    public int findDiameter(TreeNode root) {

        if (root == null) {
            // give a penalty
            return -1;
        }

        int left = findDiameter(root.left);
        int right = findDiameter(root.right);

        this.diameter = Math.max(this.diameter, left + right + 2);

        return Math.max(left, right) + 1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        findDiameter(root);

        return this.diameter;
    }

}
