package org.kakao22;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class P1_2_Report_ResultTest {

    P1_2_Report_Result p1;

    @BeforeEach
    void setUp() {
        p1 = new P1_2_Report_Result();
    }

    @Test
    void reportResult() {
        // given
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int k = 2;
        int[] expected = {2, 1, 1, 0};

        // when
        P1_1_Report_Result p1 = new P1_1_Report_Result();
        int[] answer = p1.solution(id_list, report, k);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }
}
