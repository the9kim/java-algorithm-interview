package org.javaalgorithminterview.ch14_tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class P58_3_Minimum_Distance_Between_BST_Nodes {

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
     * The book solution Utilizing iterative in-order traversal.
     */
    public int minDiffInBST(TreeNode root) {

        int minDiff = Integer.MAX_VALUE;
        int prev = Integer.MIN_VALUE + 100000;

        Deque<TreeNode> stack = new ArrayDeque<>();

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            minDiff = Math.min(minDiff, root.val - prev);
            prev = root.val;

            root = root.right;
        }

        return minDiff;
    }
}
