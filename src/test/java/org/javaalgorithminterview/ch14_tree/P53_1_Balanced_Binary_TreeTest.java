package org.javaalgorithminterview.ch14_tree;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class P53_1_Balanced_Binary_TreeTest {

    @Test
    void isBalanced() {
        // given
        Integer[] rootArray = new Integer[]{3, 9, 20, null, null, 15, 7};
        P53_1_Balanced_Binary_Tree.TreeNode root = P53_1_Balanced_Binary_Tree.TreeNode.constructBinaryTree(rootArray, 0);
        P53_1_Balanced_Binary_Tree p53 = new P53_1_Balanced_Binary_Tree();

        // when
        boolean balanced = p53.isBalanced(root);

        // then
        assertThat(balanced).isTrue();
    }

    @Test
    void isBalanced2() {
        // given
        Integer[] rootArray = new Integer[]{1,2,3,4,5,6,null,8};
        P53_1_Balanced_Binary_Tree.TreeNode root = P53_1_Balanced_Binary_Tree.TreeNode.constructBinaryTree(rootArray, 0);
        P53_1_Balanced_Binary_Tree p53 = new P53_1_Balanced_Binary_Tree();

        // when
        boolean balanced = p53.isBalanced(root);

        // then
        assertThat(balanced).isTrue();
    }

    @Test
    void isNotBalanced() {
        // given
        Integer[] rootArray = new Integer[]{1,2,2,3,3,null,null,4,4};
        P53_1_Balanced_Binary_Tree.TreeNode root = P53_1_Balanced_Binary_Tree.TreeNode.constructBinaryTree(rootArray, 0);
        P53_1_Balanced_Binary_Tree p53 = new P53_1_Balanced_Binary_Tree();

        // when
        boolean balanced = p53.isBalanced(root);

        // then
        assertThat(balanced).isFalse();
    }


}
