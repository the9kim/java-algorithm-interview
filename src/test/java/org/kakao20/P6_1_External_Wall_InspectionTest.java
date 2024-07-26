package org.kakao20;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P6_1_External_Wall_InspectionTest {

    @Test
    void solution() {
        // given
        int n = 12;
        int[] weak = {1, 5, 6, 10};
        int[] dist = {1, 2, 3, 4};
        int expected = 2;

        // when
        P6_1_External_Wall_Inspection p6 = new P6_1_External_Wall_Inspection();
        int answer = p6.solution(n, weak, dist);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }
}
