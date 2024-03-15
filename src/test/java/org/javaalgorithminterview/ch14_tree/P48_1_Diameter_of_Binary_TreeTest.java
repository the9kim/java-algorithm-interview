package org.javaalgorithminterview.ch14_tree;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class P48_1_Diameter_of_Binary_TreeTest {

    @Test
    void diameterOfBinaryTree() {
        // given
        P48_1_Diameter_of_Binary_Tree p48 = new P48_1_Diameter_of_Binary_Tree();

        P48_1_Diameter_of_Binary_Tree.TreeNode node5 = new P48_1_Diameter_of_Binary_Tree.TreeNode(5);
        P48_1_Diameter_of_Binary_Tree.TreeNode node4 = new P48_1_Diameter_of_Binary_Tree.TreeNode(4);
        P48_1_Diameter_of_Binary_Tree.TreeNode node3 = new P48_1_Diameter_of_Binary_Tree.TreeNode(3);
        P48_1_Diameter_of_Binary_Tree.TreeNode node2 = new P48_1_Diameter_of_Binary_Tree.TreeNode(2, node4, node5);
        P48_1_Diameter_of_Binary_Tree.TreeNode node1 = new P48_1_Diameter_of_Binary_Tree.TreeNode(1, node2, node3);

        int expected = 3;

        // when
        int depth = p48.diameterOfBinaryTree(node1);

        // then
        System.out.println(depth);

        assertThat(depth).isEqualTo(expected);
    }
}
