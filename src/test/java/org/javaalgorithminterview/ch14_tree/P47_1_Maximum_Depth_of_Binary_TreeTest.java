package org.javaalgorithminterview.ch14_tree;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.javaalgorithminterview.ch14_tree.P47_1_Maximum_Depth_of_Binary_Tree.TreeNode;

class P47_1_Maximum_Depth_of_Binary_TreeTest {

    @Test
    void maxDepth() {
        // given
        P47_1_Maximum_Depth_of_Binary_Tree p47 = new P47_1_Maximum_Depth_of_Binary_Tree();

        TreeNode node7 = new TreeNode(3);
        TreeNode node6 = new TreeNode(15);
        TreeNode node3 = new TreeNode(15, node6, node7);
        TreeNode node2 = new TreeNode(15);
        TreeNode node1 = new TreeNode(15, node2, node3);

        int expected = 3;

        // when
        int depth = p47.maxDepth(node1);

        // then
        System.out.println(depth);

        assertThat(depth).isEqualTo(expected);
    }
}
