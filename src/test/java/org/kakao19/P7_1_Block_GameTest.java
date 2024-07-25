package org.kakao19;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P7_1_Block_GameTest {

    @Test
    void solution() {
        // given
        int[][] board = {
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,4,0,0,0},
                {0,0,0,0,0,4,4,0,0,0},
                {0,0,0,0,3,0,4,0,0,0},
                {0,0,0,2,3,0,0,0,5,5},
                {1,2,2,2,3,3,0,0,0,5},
                {1,1,1,0,0,0,0,0,0,5}
        };

        int expected = 2;

        // when
        P7_1_Block_Game p7 = new P7_1_Block_Game();
        int answer = p7.solution(board);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);

    }
}
