package org.javaalgorithminterview.ch14_tree;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;

class P49_1_Longest_Univalue_PathTest {

    @Test
    void longestUnivaluePath() {

        // given
        Integer[] rootArray = new Integer[]
                {1,
                        2, 3,
                        3, 4, 3, 4,
                        null, null, 4, 4, null, null, null, null,
                        null, null, null, null, null, 4, null, null, null, null, null, null, null, null, null, null,
                        null, null, null, null, null, null, null, null, null, null, 4, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null

                };
        P49_1_Longest_Univalue_Path.TreeNode root = P49_1_Longest_Univalue_Path.TreeNode.constructBinaryTree(rootArray, 0);
        System.out.println(root);

        int expected = 4;

        // when
        P49_1_Longest_Univalue_Path p49 = new P49_1_Longest_Univalue_Path();
        int pathLength = p49.longestUnivaluePath(root);

        // then
        assertThat(pathLength).isEqualTo(4);
    }
}
