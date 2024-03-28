package org.javaalgorithminterview.ch14_tree;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

class P54_1_Minimum_Height_TreesTest {

    @Test
    void findMinHeightTrees() {
        // given
        int n = 7;
        int[][] edges = new int[][]{
                {0, 3},
                {1, 3},
                {2, 3},
                {4, 3},
                {5, 3},
                {6, 5}};

        List<Integer> expected = List.of(3, 5);

        // when
        P54_1_Minimum_Height_Trees p54 = new P54_1_Minimum_Height_Trees();
        List<Integer> MHTs = p54.findMinimumHeightTrees(n, edges);

        // then
        assertThat(MHTs).isEqualTo(expected);
    }

    @Test
    void createEdgeMap() {
        // given
        int[][] edges = new int[][]{
                {0, 3},
                {1, 3},
                {2, 3},
                {4, 3},
                {5, 3},
                {6, 5}};

        Map<Integer, List<Integer>> expected =
                Map.of(0, List.of(3),
                        1, List.of(3),
                        2, List.of(3),
                        3, List.of(0, 1, 2, 4, 5),
                        4, List.of(3),
                        5, List.of(3, 6),
                        6, List.of(5));


        // when
        Map<Integer, List<Integer>> edgeMap = new HashMap<>();
        for (int[] edge : edges) {
            edgeMap.putIfAbsent(edge[0], new ArrayList<>());
            edgeMap.putIfAbsent(edge[1], new ArrayList<>());
            edgeMap.get(edge[0]).add(edge[1]);
            edgeMap.get(edge[1]).add(edge[0]);
        }

        // then
        System.out.println(edgeMap);

        assertThat(edgeMap).isEqualTo(expected);
    }

    @Test
    void createTree() {
        // given
        Map<Integer, List<Integer>> edgeMap =
                Map.of(0, List.of(3),
                        1, List.of(3),
                        2, List.of(3),
                        3, List.of(0, 1, 2, 4, 5),
                        4, List.of(3),
                        5, List.of(3, 6),
                        6, List.of(5));
        Integer val = 3;

        P54_1_Minimum_Height_Trees.TreeNode expected = new P54_1_Minimum_Height_Trees.TreeNode(3, List.of(
                new P54_1_Minimum_Height_Trees.TreeNode(0),
                new P54_1_Minimum_Height_Trees.TreeNode(1),
                new P54_1_Minimum_Height_Trees.TreeNode(2),
                new P54_1_Minimum_Height_Trees.TreeNode(4),
                new P54_1_Minimum_Height_Trees.TreeNode(5, List.of(new P54_1_Minimum_Height_Trees.TreeNode(6)))
        ));

        // when
        P54_1_Minimum_Height_Trees p54 = new P54_1_Minimum_Height_Trees();

        P54_1_Minimum_Height_Trees.TreeNode root = p54.createTree(edgeMap, val, null);


        // then
        assertTreeNodeEquality(root, expected);

    }

    public void assertTreeNodeEquality(P54_1_Minimum_Height_Trees.TreeNode actual, P54_1_Minimum_Height_Trees.TreeNode expected) {
        assertThat(actual.val).isEqualTo(expected.val);
        System.out.println(actual.val);
        assertThat(actual.children.size()).isEqualTo(expected.children.size());
        for (int i = 0; i < actual.children.size(); i++) {
            assertTreeNodeEquality(actual.children.get(i), expected.children.get(i));
        }
    }

    @Test
    void calculateHeight() {

        // given
        P54_1_Minimum_Height_Trees.TreeNode root = new P54_1_Minimum_Height_Trees.TreeNode(3, List.of(
                new P54_1_Minimum_Height_Trees.TreeNode(0),
                new P54_1_Minimum_Height_Trees.TreeNode(1),
                new P54_1_Minimum_Height_Trees.TreeNode(2),
                new P54_1_Minimum_Height_Trees.TreeNode(4),
                new P54_1_Minimum_Height_Trees.TreeNode(5, List.of(new P54_1_Minimum_Height_Trees.TreeNode(6)))
        ));

        int expected = 2;

        // when
        P54_1_Minimum_Height_Trees p54 = new P54_1_Minimum_Height_Trees();
        int height = p54.calculateHeight(root);

        // then
        System.out.println(height);
        assertThat(height).isEqualTo(expected);

    }
}
