package org.javaalgorithminterview.ch14_tree;

public class P51_1_Merge_Two_Binary_Tree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    // This solution uses four conditional branches
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        TreeNode node = new TreeNode();

        if (root1 != null && root2 != null) {
            node.val = root1.val + root2.val;
            node.left = mergeTrees(root1.left, root2.left);
            node.right = mergeTrees(root1.right, root2.right);
            return node;
        } else if (root1 != null && root2 == null) {
            node.val = root1.val;
            node.left = mergeTrees(root1.left, null);
            node.right = mergeTrees(root1.right, null);
            return node;
        } else if (root1 == null && root2 != null) {
            node.val = root2.val;
            node.left = mergeTrees(null, root2.left);
            node.right = mergeTrees(null, root2.right);
            return node;
        } else {
            return null;
        }
    }
    // The book solution: if one node is null, return the other node
    public TreeNode mergeTrees2(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        TreeNode node = new TreeNode(root1.val + root2.val);
        node.left = mergeTrees2(root1.left, root2.left);
        node.right = mergeTrees2(root1.right, root2.right);
        return node;
    }
}
