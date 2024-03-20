package org.javaalgorithminterview.ch14_tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * This solution focus on deserialize logic
 */
public class P52_2_Serialize_and_Deserialize_Binary_Tree {

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

    /**
     * The book solution.
     * This method serializes a binary tree while representing null values of leaf nodes
     * <p>
     * Transfer a TreeNode type to a single String type using iterative BFS.
     */
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);
        sb.append("#," + root.val);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();

            if (node.left != null) {
                q.offer(node.left);
                sb.append("," + node.left.val);
            } else {
                sb.append(",#");
            }

            if (node.right != null) {
                q.offer(node.right);
                sb.append("," + node.right.val);
            } else {
                sb.append(",#");
            }
        }
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        if (data.equals("")) {
            return null;
        }
        String[] nodeValues = data.split(",");
        TreeNode root = new TreeNode(Integer.valueOf(nodeValues[1]));

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int index = 2;

        while (!q.isEmpty()) {
            TreeNode node = q.poll();

            if (!nodeValues[index].equals("#")) {
                TreeNode left = new TreeNode(Integer.valueOf(nodeValues[index]));
                node.left = left;
                q.add(left);
            }
            index++;

            if (!nodeValues[index].equals("#")) {
                TreeNode right = new TreeNode(Integer.valueOf(nodeValues[index]));
                node.right = right;
                q.offer(right);
            }
            index++;
        }

        return root;
    }
}
