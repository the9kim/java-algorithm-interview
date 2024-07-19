package org.kakao19;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P5_1_Path_Finding_GameTest {

    @Test
    void solution() {
        // given
        int[][] nodeinfo = {
                {5, 3},
                {11, 5},
                {13, 3},
                {3, 5},
                {6, 1},
                {1, 3},
                {8, 6},
                {7, 2},
                {2, 2}
        };
        int[][] expected = {{7, 4, 6, 9, 1, 8, 5, 2, 3}, {9, 6, 5, 8, 1, 4, 3, 2, 7}};

        // when
        P5_1_Path_Finding_Game p5 = new P5_1_Path_Finding_Game();
        int[][] answer = p5.solution(nodeinfo);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);

    }
}
