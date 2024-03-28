package org.javaalgorithminterview.ch14_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P57_1_Range_Sum_of_BST {

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

    public List<Integer> dfs(TreeNode root, int low, int high, List<Integer> path) {
        if (root == null) {
            return path;
        }

        if (root.val >= low && root.val <= high) {
            path.add(root.val);
        }

        if (root.val <= low) {
            path = dfs(root.right, low, high, path);
        } else if (root.val >= high) {
            path = dfs(root.left, low, high, path);
        } else {
            path = dfs(root.left, low, high, path);
            path = dfs(root.right, low, high, path);
        }

        return path;
    }

    public int rangeSumBST(TreeNode root, int low, int high) {
        List<Integer> path = dfs(root, low, high, new ArrayList<>());

        return path.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
