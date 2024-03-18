package org.javaalgorithminterview.ch14_tree;

import java.util.Objects;

/**
 * This method creates new nodes using recursive DFS.
 */
public class P50_1_Invert_Binary_Tree {

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

    /**
     * The method uses a copy of the left node.
     */
//    public TreeNode invertTree(TreeNode root) {
//        if (root == null) {
//            return null;
//        }
//
//        TreeNode leftCopy = null;
//        if (root.left != null) {
//            leftCopy = new TreeNode(root.left.val, root.left.left, root.left.right);
//        }
//
//        root.left = invertTree(root.right);
//        root.right = invertTree(leftCopy);
//
//        return root;
//    }


    /**
     * This method copies the root node itself, which makes it clearer to read.
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode rootCopy = new TreeNode(root.val);
        rootCopy.left = invertTree(root.right);
        rootCopy.right = invertTree(root.left);

        return rootCopy;
    }
}
