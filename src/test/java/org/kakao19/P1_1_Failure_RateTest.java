package org.kakao19;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class P1_1_Failure_RateTest {

    @Test
    void failureRate() {
        // given
        int N = 5;
        int[] stages = new int[]{2, 1, 2, 6, 2, 4, 3, 3};
        int[] expected = new int[]{3, 4, 2, 1, 5};

        // when
        P1_1_Failure_Rate p1 = new P1_1_Failure_Rate();
        int[] answer = p1.solution(N, stages);

        // then
        assertThat(answer).isEqualTo(expected);
    }
}
