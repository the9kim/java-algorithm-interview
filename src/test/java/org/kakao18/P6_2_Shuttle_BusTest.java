package org.kakao18;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P6_2_Shuttle_BusTest {

    @Test
    void solution() {
        // given
        int n = 1;
        int t = 1;
        int m = 5;
        String[] timetable = {"08:00", "08:01", "08:02", "08:03"};

        String expected = "09:00";

        // when
        P6_2_Shuttle_Bus p6 = new P6_2_Shuttle_Bus();
        String answer = p6.solution(n, t, m, timetable);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }

}
