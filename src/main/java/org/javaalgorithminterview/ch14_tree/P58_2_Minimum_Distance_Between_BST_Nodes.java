package org.javaalgorithminterview.ch14_tree;

import java.util.LinkedList;
import java.util.Queue;

public class P58_2_Minimum_Distance_Between_BST_Nodes {

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

    int diff = Integer.MAX_VALUE ;
    int prev = Integer.MIN_VALUE + 100000;

    /**
     * The book solution Utilizing recursive in-order traversal.
     */
    public int minDiffInBST(TreeNode root) {

        if (root.left != null) {
            minDiffInBST(root.left);
        }

        diff = Math.min(diff, root.val - prev);
        prev = root.val;

        if (root.right != null) {
            minDiffInBST(root.right);
        }
        return diff;
    }
}
