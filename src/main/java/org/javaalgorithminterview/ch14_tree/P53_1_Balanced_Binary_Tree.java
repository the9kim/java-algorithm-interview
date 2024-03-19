package org.javaalgorithminterview.ch14_tree;

import java.util.LinkedList;
import java.util.Queue;

public class P53_1_Balanced_Binary_Tree {
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

        public static TreeNode constructBinaryTree(Integer[] rootArray, int index) {
            TreeNode node = null;

            if (index < rootArray.length && rootArray[index] != null) {
                node = new TreeNode(rootArray[index]);
                node.left = constructBinaryTree(rootArray, 2 * index + 1);
                node.right = constructBinaryTree(rootArray, 2 * index + 2);
            }

            return node;
        }
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);

        if (left == -1 || right == -1 || Math.abs((left - right)) > 1) {
            return -1;
        }

        return Math.max(left, right) + 1;
    }

    /**
     * Compare the heights of the left and right subtrees of each node to determine if the entire tree is balanced.
     */
    public boolean isBalanced(TreeNode root) {

        return dfs(root) != -1;
    }

    /**
     * This method can't handle the test case(isBalanced2())
     */
    public boolean WrongIsBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int qSize = q.size();

            for (int i = 0; i < qSize; i++) {
                TreeNode node = q.poll();
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }

            // Check if it is a perfect binary tree
            if (2 * qSize != q.size()) {
                // Check if leaf nodes have children
                while (!q.isEmpty()) {
                    TreeNode leaf = q.poll();
                    if (leaf.left != null || leaf.right != null) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
