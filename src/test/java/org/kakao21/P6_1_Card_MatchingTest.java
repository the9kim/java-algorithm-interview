package org.kakao21;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P6_1_Card_MatchingTest {

    @Test
    void solution() {
        // given
        int[][] board = {
                {1, 0, 0, 3},
                {2, 0, 0, 0},
                {0, 0, 0, 2},
                {3, 0, 1, 0}
        };
        int r = 1;
        int c = 0;

        int expected = 14;

        // when
        P6_1_Card_Matching p6 = new P6_1_Card_Matching();
        int answer = p6.solution(board, r, c);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }
}
