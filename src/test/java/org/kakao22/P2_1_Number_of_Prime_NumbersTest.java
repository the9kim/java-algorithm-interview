package org.kakao22;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P2_1_Number_of_Prime_NumbersTest {

    @Test
    void solution() {
        // given
        int n = 437674;
        int k = 3;
        int expected = 3;

        // when
        P2_1_Number_of_Prime_Numbers p2 = new P2_1_Number_of_Prime_Numbers();
        int answer = p2.solution(n, k);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }

    @Test
    void solution2() {
        // given
        int n = 110011;
        int k = 10;
        int expected = 2;

        // when
        P2_1_Number_of_Prime_Numbers p2 = new P2_1_Number_of_Prime_Numbers();
        int answer = p2.solution(n, k);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }
}
