package org.kakao20;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P5_1_Installation_of_Pillars_and_BeamsTest {

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



        // when
        P5_1_Installation_of_Pillars_and_Beams p5 = new P5_1_Installation_of_Pillars_and_Beams();
        int[][] solution = p5.solution(5, build_frame);
    }
}
