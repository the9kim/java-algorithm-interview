package org.kakao23;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P7_1_Dropping_NumbersTest {

    @Test
    void solution() {
        // given
        int[][] edges = {
                {2, 4},
                {1, 2},
                {6, 8},
                {1, 3},
                {5, 7},
                {2, 5},
                {3, 6},
                {6, 10},
                {6, 9}
        };
        int[] target = {0, 0, 0, 3, 0, 0, 5, 1, 2, 3};
        int[] expected = {1, 1, 2, 2, 2, 3, 3};

        // when
        P7_1_Dropping_Numbers p7 = new P7_1_Dropping_Numbers();
        int[] answer = p7.solution(edges, target);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);

    }
}
