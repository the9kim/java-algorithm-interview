package org.kakao20;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P7_2_Moving_BlocksTest {
    @Test
    void solution() {
        // given
        int[][] board = {
                {0, 0, 0, 1, 1},
                {0, 0, 0, 1, 0},
                {0, 1, 0, 1, 1},
                {1, 1, 0, 0, 1},
                {0, 0, 0, 0, 0}
        };
        int expected = 7;

        // when
        P7_2_Moving_Blocks p7 = new P7_2_Moving_Blocks();
        int answer = p7.solution(board);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);

    }
}
