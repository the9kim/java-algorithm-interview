package org.kakao23;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P1_1_Personal_Information_Collection_Validity_PeriodTest {

    @Test
    void solution() {
        // given
        String today = "2022.05.19";
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
        int[] expected = {1, 3};

        // when
        P1_1_Personal_Information_Collection_Validity_Period p1 = new P1_1_Personal_Information_Collection_Validity_Period();
        int[] answer = p1.solution(today, terms, privacies);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }
}
