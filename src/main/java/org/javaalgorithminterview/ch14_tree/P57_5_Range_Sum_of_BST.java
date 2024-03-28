package org.javaalgorithminterview.ch14_tree;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class P57_5_Range_Sum_of_BST {

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

        public static TreeNode construct(Integer[] nodes) {
            if (nodes.length == 0) {
                return null;
            }

            TreeNode root = new TreeNode(nodes[0]);

            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);

            int index = 1;

            while (!q.isEmpty()) {
                TreeNode node = q.poll();

                if (index < nodes.length && nodes[index] != null) {
                    TreeNode left = new TreeNode(nodes[index]);
                    node.left = left;
                    q.offer(left);
                }
                index++;

                if (index < nodes.length && nodes[index] != null) {
                    TreeNode right = new TreeNode(nodes[index]);
                    node.right = right;
                    q.offer(right);
                }
                index++;
            }

            return root;
        }
    }


    /**
     * The book solution using iterative BFS with pruning
     */
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        int sum = 0;

        while (!q.isEmpty()) {
            TreeNode node = q.poll();

            if (node.val >= low && node.val <= high) {
                sum += node.val;
            }
            if (node.val > low && node.left != null) {
                q.offer(node.left);
            }
            if (node.val < high && node.right != null) {
                q.offer(node.right);
            }
        }
        return sum;
    }
}
