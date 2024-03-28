package org.javaalgorithminterview.ch14_tree;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class P59_1_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {

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

    public TreeNode dfs(List<Integer> preorder, List<Integer> inorder) {
        if (preorder.size() == 0) {
            return null;
        }

        // 1
        int rootVal = preorder.get(0);
        TreeNode root = new TreeNode(rootVal);

        // 2
        int rootIndex = inorder.indexOf(rootVal);
        List<Integer> leftSubIn = inorder.subList(0, rootIndex);
        List<Integer> rightSubIn = inorder.subList(rootIndex + 1, preorder.size());

        List<Integer> leftSubPre = preorder.subList(1, 1 + leftSubIn.size());
        List<Integer> rightSubPre = preorder.subList(1 + leftSubIn.size(), preorder.size());

        // 3
        root.left = dfs(leftSubPre, leftSubIn);
        root.right = dfs(rightSubPre, rightSubIn);

        return root;
    }

    /**
     * Divide and Conquer using reference Type(List)
     *
     * 1. Find and Create the root node.
     * 2. Separate left and right subtrees from preorder and inorder arrays.
     * 3. Create the left and right subtrees separately using recursive DFS.
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        List<Integer> pre = Arrays.stream(preorder)
                .boxed()
                .collect(Collectors.toList());

        List<Integer> in = Arrays.stream(inorder)
                .boxed()
                .collect(Collectors.toList());

        return dfs(pre, in);
    }
}
