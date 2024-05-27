package org.kakao18;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P1_1_Dart_GameTest {

    @Test
    void dartGame() {
        // given
        String dartResult = "1D#2S*3S";
        int expected = 5;

        // when
        P1_1_Dart_Game p1 = new P1_1_Dart_Game();
        int answer = p1.solution(dartResult);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }

    @Test
    void dartGame2() {
        // given
        String dartResult = "1D2S#10S";
        int expected = 9;

        // when
        P1_1_Dart_Game p1 = new P1_1_Dart_Game();
        int answer = p1.solution(dartResult);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }
}
