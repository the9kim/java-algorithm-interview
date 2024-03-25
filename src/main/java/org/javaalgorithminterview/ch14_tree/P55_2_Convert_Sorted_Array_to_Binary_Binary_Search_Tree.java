package org.javaalgorithminterview.ch14_tree;

import java.util.Arrays;

public class P55_2_Convert_Sorted_Array_to_Binary_Binary_Search_Tree {
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

    public TreeNode construct(int[] nums, int left, int right) {

        if (left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;

        TreeNode node = new TreeNode(nums[mid]);
        node.left = construct(nums, left, mid - 1);
        node.right = construct(nums, mid + 1, right);

        return node;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        return construct(nums, 0, nums.length - 1);
    }
}
