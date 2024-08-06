package org.kakao22;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P6_2_Undamaged_BuildingsTest {

    @Test
    void solution() {
        // given
        int[][] board = {
                {5, 5, 5, 5, 5},
                {5, 5, 5, 5, 5},
                {5, 5, 5, 5, 5},
                {5, 5, 5, 5, 5}};

        int[][] skill = {
                {1, 0, 0, 3, 4, 4},
                {1, 2, 0, 2, 3, 2},
                {2, 1, 0, 3, 1, 2},
                {1, 0, 1, 3, 3, 1}
        };
        int expected = 10;

        // when
        P6_2_Undamaged_Buildings p6 = new P6_2_Undamaged_Buildings();
        int answer = p6.solution(board, skill);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }
}
