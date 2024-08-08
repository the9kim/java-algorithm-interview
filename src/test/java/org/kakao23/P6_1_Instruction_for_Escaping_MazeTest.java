package org.kakao23;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class P6_1_Instruction_for_Escaping_MazeTest {

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
        P6_1_Instruction_for_Escaping_Maze p6 = new P6_1_Instruction_for_Escaping_Maze();
        String answer = p6.solution(n, m, x, y, r, c, k);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);

    }
}
