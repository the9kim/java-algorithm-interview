package org.javaalgorithminterview.ch14_tree;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class P55_1_Convert_Sorted_Array_to_Binary_Binary_Search_Tree {
    public static class TreeNode {
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

    public TreeNode sortedArrayToBST(int[] nums) {

        if (nums.length < 1) {
            return null;
        }

        int rootIdx = nums.length / 2;

        TreeNode root = new TreeNode(nums[rootIdx]);

        root.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, rootIdx));
        root.right = sortedArrayToBST(Arrays.copyOfRange(nums, rootIdx + 1, nums.length));

        return root;
    }
}
