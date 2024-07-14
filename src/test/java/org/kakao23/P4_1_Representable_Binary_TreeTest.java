package org.kakao23;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P4_1_Representable_Binary_TreeTest {

    @Test
    void solution() {
        // given
        long[] numbers = {7, 42, 5};
        int[] expected = {1, 1, 0};

        // when
        P4_1_Representable_Binary_Tree p4 = new P4_1_Representable_Binary_Tree();
        int[] answer = p4.solution(numbers);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }

    @Test
    void solution2() {
        // given
        long[] numbers = {63, 111, 95};
        int[] expected = {1, 1, 0};

        // when
        P4_1_Representable_Binary_Tree p4 = new P4_1_Representable_Binary_Tree();
        int[] answer = p4.solution(numbers);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }

    @Test
    void deserializable() {
        // given
        char[] bin = {'0', '1', '0', '1', '0', '1', '0'};
        int left = 0;
        int right = bin.length - 1;

        boolean expected = true;

        // when
        P4_1_Representable_Binary_Tree p4 = new P4_1_Representable_Binary_Tree();
        boolean answer = p4.deserializable(bin, left, right, false);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }

    @Test
    void should_not_deserializable() {
        // given
        char[] bin = {'1', '0', '1'};
        int left = 0;
        int right = bin.length - 1;

        boolean expected = false;

        // when
        P4_1_Representable_Binary_Tree p4 = new P4_1_Representable_Binary_Tree();
        boolean answer = p4.deserializable(bin, left, right, false);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }

    @Test
    void should_not_deserializable2() {
        // given
        char[] bin = {'1', '0', '1', '1', '1', '1', '1'};
        int left = 0;
        int right = bin.length - 1;

        boolean expected = false;

        // when
        P4_1_Representable_Binary_Tree p4 = new P4_1_Representable_Binary_Tree();
        boolean answer = p4.deserializable(bin, left, right, false);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);

    }
}
