package org.javaalgorithminterview.ch14_tree;

public class P59_2_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {

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

    public TreeNode dfs(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {

        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }

        int inIndex = 0;

        // 1
        for (int i = inStart; i <= inEnd; i++) {
            if (preorder[preStart] == inorder[i]) {
                inIndex = i;
            }
        }

        TreeNode root = new TreeNode(inorder[inIndex]);

        preStart++;

        // 2 & 3
        root.left = dfs(preStart, inStart, inIndex - 1, preorder, inorder);
        root.right = dfs(preStart + inIndex - inStart, inIndex + 1, inEnd, preorder, inorder);

        return root;

    }

    /**
     * Divide and Conquer using Primitive Type(int index)
     *
     * 1. Find and Create the root node.
     * 2. Separate left and right subtrees from preorder and inorder arrays.
     * 3. Create the left and right subtrees separately using recursive DFS.
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        return dfs(0, 0, inorder.length - 1, preorder, inorder);
    }
}
