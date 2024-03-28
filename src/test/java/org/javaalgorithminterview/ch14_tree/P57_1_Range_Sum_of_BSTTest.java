package org.javaalgorithminterview.ch14_tree;

import org.junit.jupiter.api.Test;

import static org.javaalgorithminterview.ch14_tree.P57_1_Range_Sum_of_BST.TreeNode.construct;
import static org.assertj.core.api.Assertions.*;

class P57_1_Range_Sum_of_BSTTest {

    @Test
    void rangeSumBST() {
        // given
        Integer[] nodes = {10, 5, 15, 3, 7, 13, 18, 1, null, 6, null, 11};
        P57_1_Range_Sum_of_BST.TreeNode root = construct(nodes);
        int low = 6;
        int high = 13;

        int expected = 47;

        // when
        P57_1_Range_Sum_of_BST p56 = new P57_1_Range_Sum_of_BST();
        int rangeSum = p56.rangeSumBST(root, low, high);

        // then
        assertThat(rangeSum).isEqualTo(expected);
    }

    @Test
    void rangeSumBST2() {
        // given
        Integer[] nodes = {18, 9, 27, 6, 15, 24, 30, 3, null, 12, null, 21};
        P57_1_Range_Sum_of_BST.TreeNode root = construct(nodes);
        int low = 18;
        int high = 24;

        int expected = 63;

        // when
        P57_1_Range_Sum_of_BST p56 = new P57_1_Range_Sum_of_BST();
        int rangeSum = p56.rangeSumBST(root, low, high);

        // then
        assertThat(rangeSum).isEqualTo(expected);
    }
}
