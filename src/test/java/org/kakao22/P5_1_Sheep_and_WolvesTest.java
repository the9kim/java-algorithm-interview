package org.kakao22;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class P5_1_Sheep_and_WolvesTest {

    @Test
    void solution() {
        // given
        int[] info = {0,0,1,1,1,0,1,0,1,0,1,1};
        int[][] edges = {
                {0, 1},
                {1, 2},
                {1, 4},
                {0, 8},
                {8, 7},
                {9, 10},
                {9, 11},
                {4, 3},
                {6, 5},
                {4, 6},
                {8, 9}
        };
        int expected = 5;

        // when
        P5_1_Sheep_and_Wolves p5 = new P5_1_Sheep_and_Wolves();
        int answer = p5.solution(info, edges);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }
}
