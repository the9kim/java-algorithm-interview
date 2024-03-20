package org.javaalgorithminterview.ch14_tree;

import org.javaalgorithminterview.ch14_tree.P52_1_Serialize_and_Deserialize_Binary_Tree.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.StringJoiner;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;

class P52_1_Serialize_and_Deserialize_Binary_TreeTest {

    @Test
    void serializeFromArrayToString() {
        // given
        Integer[] binArr = {1, 2, 3, null, null, 4, 5};

        String expected = "1,2,3,null,null,4,5";

        // when
        StringJoiner sj = new StringJoiner(",");

        for (Integer val : binArr) {
            if (val == null) {
                sj.add("null");

            } else {
                sj.add(val.toString());
            }
        }

        // then
        assertThat(sj.toString()).isEqualTo(expected);
    }

    @Test
    void serializeFromArrayToString2() {
        // given
        Integer[] binArr = {1, 2, 3, null, null, 4, 5};

        String expected = "1,2,3,null,null,4,5";

        // when
        String s = Arrays.stream(binArr)
                .map(val -> val == null ? "null" : val.toString())
                .collect(Collectors.joining(","));

        // then
        assertThat(s).isEqualTo(expected);
    }

    @Test
    void serializeFromStringToArray() {
        // given
        String s = "1,2,3,null,null,4,5";
        Integer[] expected = {1, 2, 3, null, null, 4, 5};

        // when
        String[] sArr = s.split(",");

        Integer[] arr = Arrays.stream(sArr)
                .map(val -> val.equals("null") ? null : Integer.valueOf(val))
                .toArray(Integer[]::new);

        // then
        assertThat(arr).isEqualTo(expected);
    }

    @Test
    void constructBinaryTree() {

        // given
        Integer[] nodeValues = new Integer[]{1, 2, 3, null, null, 4, 5, 6, 7};

        TreeNode node7 = new TreeNode(7);
        TreeNode node6 = new TreeNode(6);
        TreeNode node5 = new TreeNode(5);
        TreeNode node4 = new TreeNode(4, node6, node7);
        TreeNode node3 = new TreeNode(3, node4, node5);
        TreeNode node2 = new TreeNode(2);
        TreeNode node1 = new TreeNode(1, node2, node3);

        // when
        TreeNode answer = TreeNode.constructBinaryTree(nodeValues, 0);

        // then
        assertThat(answer.right.left.left).isNull();
        assertThat(answer.right.left.right).isNull();
    }

    @Test
    void serializeBinaryTree() {
        // given
        Integer[] nodeValues = new Integer[]{1, 2, 3, null, null, 4, 5, null, null, null, null, 6, 7, null, null};
        TreeNode root = TreeNode.constructBinaryTree(nodeValues, 0);

        P52_1_Serialize_and_Deserialize_Binary_Tree p52 = new P52_1_Serialize_and_Deserialize_Binary_Tree();

        String expected =
                "1," +
                        "2,3," +
                        "null,null,4,5," +
                        "null,null,null,null,6,7,null,null";

        // when
        String serialized = p52.serialize(root);

        // then
        System.out.println(serialized);

        assertThat(serialized).isEqualTo(expected);
    }

    @Test
    void deserializeBinaryTree() {
        // given
        String data = "1,2,3,null,null,4,5,null,null,null,null,6,7,null,null";

        P52_1_Serialize_and_Deserialize_Binary_Tree p52 = new P52_1_Serialize_and_Deserialize_Binary_Tree();

        Integer[] nodeValues = new Integer[]{1, 2, 3, null, null, 4, 5, null, null, null, null, 6, 7, null, null};
        TreeNode expected = TreeNode.constructBinaryTree(nodeValues, 0);

        // when
        TreeNode answer = p52.deserialize(data);

        // then
        System.out.println(answer);


        assertThat(dfs(answer, expected)).isTrue();
    }

    @Test
    void serializeAndDeserializeBinaryTree() {
        // given
        Integer[] nodeValues = new Integer[]{1, 2, 3, null, null, 4, 5, null, null, null, null, 6, 7, null, null};
        TreeNode root = TreeNode.constructBinaryTree(nodeValues, 0);

        P52_1_Serialize_and_Deserialize_Binary_Tree p52 = new P52_1_Serialize_and_Deserialize_Binary_Tree();

        // when
        TreeNode answer = p52.deserialize(p52.serialize(root));

        // then

        assertThat(dfs(answer, root)).isTrue();
    }

    private boolean dfs(TreeNode answer, TreeNode expected) {
        if (answer == null && expected == null) {
            return true;
        }
        if ((answer == null && expected != null)
                || (answer != null && expected == null)
                || answer.val != expected.val) {

            return false;
        }

        if (!dfs(answer.left, expected.left)) {
            return false;
        }
        if (!dfs(answer.right, expected.right)) {
            return false;
        }

        return true;
    }
}
