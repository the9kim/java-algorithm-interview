package org.kakao23;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P6_2_Instruction_for_Escaping_MazeTest {

    @Test
    void solution() {
        // given
        int n = 3;
        int m = 4;
        int x = 2;
        int y = 3;
        int r = 3;
        int c = 1;
        int k = 5;
        String expected = "dllrl";

        // when
        P6_2_Instruction_for_Escaping_Maze p6 = new P6_2_Instruction_for_Escaping_Maze();
        String answer = p6.solution(n, m, x, y, r, c, k);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);

    }

    @Test
    void solution2() {
        // given
        int n = 3;
        int m = 3;
        int x = 1;
        int y = 2;
        int r = 3;
        int c = 3;
        int k = 4;
        String expected = "impossible";

        // when
        P6_2_Instruction_for_Escaping_Maze p6 = new P6_2_Instruction_for_Escaping_Maze();
        String answer = p6.solution(n, m, x, y, r, c, k);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);

    }

}
