package org.javaalgorithminterview.ch14_tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P55_1_Convert_Sorted_Array_to_Binary_Binary_Search_TreeTest {

    @Test
    void sortedArrayToBST() {
        // given
        int[] nums = {-10, -3, -1, 0, 5, 9, 11};

        // when
        P55_1_Convert_Sorted_Array_to_Binary_Binary_Search_Tree p55 = new P55_1_Convert_Sorted_Array_to_Binary_Binary_Search_Tree();
        P55_1_Convert_Sorted_Array_to_Binary_Binary_Search_Tree.TreeNode treeNode = p55.sortedArrayToBST(nums);

        // then
        System.out.println(treeNode.val);
        System.out.println(treeNode.left.val);
        System.out.println(treeNode.right.val);
    }
}
