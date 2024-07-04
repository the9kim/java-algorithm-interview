package org.kakao22;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P4_1_Archery_TournamentTest {

    @Test
    void solution() {
        // given
        int n = 5;
        int[] info = {2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0};
        int[] expected = {0, 2, 2, 0, 1, 0, 0, 0, 0, 0, 0};

        // when
        P4_1_Archery_Tournament p4 = new P4_1_Archery_Tournament();
        int[] answer = p4.solution(n, info);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);

    }
}
