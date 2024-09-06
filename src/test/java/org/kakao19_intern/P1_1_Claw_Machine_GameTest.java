package org.kakao19_intern;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P1_1_Claw_Machine_GameTest {

    @Test
    void solution() {
        // given
        int[][] board = {{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}};
        int[] moves = {1,5,3,5,1,2,1,4};
        int expected = 4;

        // when
        P1_1_Claw_Machine_Game p1 = new P1_1_Claw_Machine_Game();
        int answer = p1.solution(board, moves);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);

    }
}
