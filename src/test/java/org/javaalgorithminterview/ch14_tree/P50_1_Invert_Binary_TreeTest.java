package org.javaalgorithminterview.ch14_tree;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class P50_1_Invert_Binary_TreeTest {

    @Test
    void invertTree() {

        // given
        Integer[] rootArray = new Integer[]{1, 2, 3};
        Integer[] invertedRootArray = new Integer[]{1, 3, 2};
        P50_1_Invert_Binary_Tree.TreeNode root = P50_1_Invert_Binary_Tree.TreeNode.constructBinaryTree(rootArray, 0);

        P50_1_Invert_Binary_Tree.TreeNode expected = P50_1_Invert_Binary_Tree.TreeNode.constructBinaryTree(invertedRootArray, 0);

        P50_1_Invert_Binary_Tree p50 = new P50_1_Invert_Binary_Tree();

        // when
        P50_1_Invert_Binary_Tree.TreeNode invertedTree = p50.invertTree(root);

        // then
        assertThat(invertedTree).isEqualTo(expected);
    }
}
