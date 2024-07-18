package org.kakao19;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P4_1_Muji_LiveTest {

    @Test
    void solution() {
        // given
        int[] food_times = {3, 1, 2};
        int k = 5;

        int expected = 1;

        // when
        P4_1_Muji_Live p4 = new P4_1_Muji_Live();
        int answer = p4.solution(food_times, k);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }

    @Test
    void solution2() {
        // given
        int[] food_times = {3, 1, 4, 7};
        int k = 13;

        int expected = 4;

        // when
        P4_1_Muji_Live p4 = new P4_1_Muji_Live();
        int answer = p4.solution(food_times, k);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }
}
