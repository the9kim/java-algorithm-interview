package org.kakao20;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class P5_2_Installation_of_Pillars_and_BeamsTest {


    @Test
    void solution() {
        // given
        int[][] build_frame = {
                {0, 0, 0, 1},
                {2, 0, 0, 1},
                {4, 0, 0, 1},
                {0, 1, 1, 1},
                {1, 1, 1, 1},
                {2, 1, 1, 1},
                {3, 1, 1, 1},
                {2, 0, 0, 0},
                {1, 1, 1, 0},
                {2, 2, 0, 1}
        };
        int n = 5;
        int[][] expected = {
                {0, 0, 0},
                {0, 1, 1},
                {1, 1, 1},
                {2, 1, 1},
                {3, 1, 1},
                {4, 0, 0}
        };

        // when
        P5_2_Installation_of_Pillars_and_Beams p5 = new P5_2_Installation_of_Pillars_and_Beams();
        int[][] answer = p5.solution(n, build_frame);


        // then

        Assertions.assertThat(answer).isEqualTo(expected);
    }
}
