package org.kakao17;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P1_1_Coloring_BookTest {

    @Test
    void solution() {
        // given
        int m = 6;
        int n = 4;
        int[][] picture = {
                {1, 1, 1, 0},
                {1, 1, 1, 0},
                {0, 0, 0, 1},
                {0, 0, 0, 1},
                {0, 0, 0, 1},
                {0, 0, 0, 1}
        };

        int[] expected = new int[]{2, 6};


        // when
        P1_1_Coloring_Book p1 = new P1_1_Coloring_Book();
        int[] answer = p1.solution(m, n, picture);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);

    }

    @Test
    void solution2() {
        // given
        int m = 6;
        int n = 4;
        int[][] picture = {
                {1, 1, 1, 0},
                {1, 2, 2, 0},
                {1, 0, 0, 1},
                {0, 0, 0, 1},
                {0, 0, 0, 3},
                {0, 0, 0, 3}
        };

        int[] expected = new int[]{4, 5};


        // when
        P1_1_Coloring_Book p1 = new P1_1_Coloring_Book();
        int[] answer = p1.solution(m, n, picture);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);

    }
}
