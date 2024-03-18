package org.javaalgorithminterview.ch14_tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * This method uses iterative BFS
 */
public class P50_5_Invert_Binary_Tree {

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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            TreeNode treeNode = (TreeNode) o;
            return val == treeNode.val;
        }

        @Override
        public int hashCode() {
            return Objects.hash(val);
        }
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();

            TreeNode leftTemp = node.left;

            node.left = node.right;
            node.right = leftTemp;

            if (node.left != null) {
                q.add(node.left);
            }
            if (node.right != null) {
                q.add(node.right);
            }
        }

        return root;
    }
}
