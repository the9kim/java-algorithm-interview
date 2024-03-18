package org.javaalgorithminterview.ch14_tree;

public class P49_1_Longest_Univalue_Path {

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

        // The method to make a binary tree with a value array
        public static TreeNode constructBinaryTree(Integer[] rootArray, int index) {
            TreeNode root = null;

            if (index < rootArray.length && rootArray[index] != null) {
                root = new TreeNode(rootArray[index]);
                root.left = constructBinaryTree(rootArray, 2 * index + 1);
                root.right = constructBinaryTree(rootArray, 2 * index + 2);
            }
            return root;
        }
    }

    int maxPath = 0;


    /**
     * This method that I made is hard to read because of duplicated if statements.
     */
//    public int dfs(TreeNode node) {
//        if (node == null) {
//            return 0;
//        }
//
//        int left = dfs(node.left);
//        int right = dfs(node.right);
//
//        if (node.left != null && node.right != null
//                && node.val == node.left.val && node.val == node.right.val) {
//            this.maxPath = Math.max(this.maxPath, left + right + 2);
//            return Math.max(left, right) + 1;
//        } else if(node.left != null && node.val == node.left.val) {
//            this.maxPath = Math.max(this.maxPath, left + 1);
//            return left + 1;
//        } else if (node.right != null && node.val == node.right.val) {
//            this.maxPath = Math.max(this.maxPath, right + 1);
//            return right + 1;
//        } else {
//            return 0;
//        }
//    }

    // The solution book suggests
    public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = dfs(node.left);
        int right = dfs(node.right);

        if (node.left != null && node.left.val == node.val) {
            left++;
        } else {
            left = 0;
        }

        if (node.right != null && node.right.val == node.val) {
            right++;
        } else {
            right = 0;
        }

        this.maxPath = Math.max(this.maxPath, left + right);

        return Math.max(left, right);
    }

    public int longestUnivaluePath(TreeNode root) {

        dfs(root);

        return maxPath;
    }
}
