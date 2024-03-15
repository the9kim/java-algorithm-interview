package org.javaalgorithminterview.ch14_tree;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class P47_2_Maximum_Depth_of_Binary_TreeTest {

    @Test
    void maxDepth() {
        // given
        P47_2_Maximum_Depth_of_Binary_Tree p47 = new P47_2_Maximum_Depth_of_Binary_Tree();

        P47_2_Maximum_Depth_of_Binary_Tree.TreeNode node7 = new P47_2_Maximum_Depth_of_Binary_Tree.TreeNode(3);
        P47_2_Maximum_Depth_of_Binary_Tree.TreeNode node6 = new P47_2_Maximum_Depth_of_Binary_Tree.TreeNode(15);
        P47_2_Maximum_Depth_of_Binary_Tree.TreeNode node3 = new P47_2_Maximum_Depth_of_Binary_Tree.TreeNode(15, node6, node7);
        P47_2_Maximum_Depth_of_Binary_Tree.TreeNode node2 = new P47_2_Maximum_Depth_of_Binary_Tree.TreeNode(15);
        P47_2_Maximum_Depth_of_Binary_Tree.TreeNode node1 = new P47_2_Maximum_Depth_of_Binary_Tree.TreeNode(15, node2, node3);

        int expected = 3;

        // when
        int depth = p47.maxDepth(node1);

        // then
        System.out.println(depth);

        assertThat(depth).isEqualTo(expected);
    }

}
