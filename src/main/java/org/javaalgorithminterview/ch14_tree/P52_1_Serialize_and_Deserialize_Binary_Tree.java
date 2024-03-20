package org.javaalgorithminterview.ch14_tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringJoiner;


/**
 * This solution focus on serialize logic
 */
public class P52_1_Serialize_and_Deserialize_Binary_Tree {

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

        public static TreeNode constructBinaryTree(Integer[] nodeValues, int index) {

            TreeNode node = null;

            if (index < nodeValues.length && nodeValues[index] != null) {
                node = new TreeNode(nodeValues[index]);
                node.left = constructBinaryTree(nodeValues, 2 * index + 1);
                node.right = constructBinaryTree(nodeValues, 2 * index + 2);
            }

            return node;
        }

    }

    /**
     * This method serializes a binary tree while representing every null value,
     * which can lead to memory overflow.
     *
     * Transfer a TreeNode type to a single String type using iterative BFS.
     */
    public String serialize(TreeNode root) {
        if (root == null) {
            return "null";
        }

        StringJoiner sj = new StringJoiner(",");

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int qSize = 1;

        while (q.stream().anyMatch(val -> val != null)) {

            for (int i = 0; i < qSize; i++) {
                TreeNode node = q.poll();

                if (node == null) {
                    sj.add("null");

                    q.offer(null);
                    q.offer(null);
                } else {
                    sj.add(String.valueOf(node.val));
                    q.offer(node.left);
                    q.offer(node.right);
                }
            }
            qSize *= 2;
        }
        return sj.toString();
    }


//    public String serialize(TreeNode root) {
//
//        StringJoiner sj = new StringJoiner(",");
//
//        Queue<TreeNode> q = new LinkedList<>();
//        q.offer(root);
//
//        while (!q.isEmpty()) {
//            TreeNode node = q.poll();
//
//            if (node == null) {
//                sj.add("null");
//            } else {
//                sj.add(String.valueOf(node.val));
//
//                q.offer(node.left);
//                q.offer(node.right);
//            }
//        }
//        return sj.toString();
//    }

    /**
     * 1. Transfer String type to an Integer Array type.
     * 2. Construct a binary tree using the Integer Array and recursive DFS.
     */

    // 2
    public TreeNode dfs(Integer[] nodeValues, int index) {
        TreeNode node = null;

        if (index < nodeValues.length && nodeValues[index] != null) {
            node = new TreeNode(nodeValues[index]);

            node.left = dfs(nodeValues, 2 * index + 1);
            node.right = dfs(nodeValues, 2 * index + 2);
        }

        return node;
    }

    public TreeNode deserialize(String data) {
        // 1
        Integer[] nodeValues = Arrays.stream(data.split(","))
                .map(val -> val.equals("null") ? null : Integer.valueOf(val))
                .toArray(Integer[]::new);

        return dfs(nodeValues, 0);
    }

}
