package org.javaalgorithminterview.ch14_tree;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class P58_3_Minimum_Distance_Between_BST_NodesTest {

    @Test
    void minDiffInBST() {
        // given
        Integer[] rootArr = {10, 4, 16, 1, 8, null, 19, null, null, 7};
        P58_3_Minimum_Distance_Between_BST_Nodes.TreeNode root = P58_3_Minimum_Distance_Between_BST_Nodes.TreeNode.construct(rootArr);
        int expected = 1;

        // when
        P58_3_Minimum_Distance_Between_BST_Nodes p57 = new P58_3_Minimum_Distance_Between_BST_Nodes();
        int minDiff = p57.minDiffInBST(root);

        // then
        assertThat(minDiff).isEqualTo(expected);

    }

}
