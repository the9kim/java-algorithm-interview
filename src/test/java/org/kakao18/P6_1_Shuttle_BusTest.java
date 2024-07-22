package org.kakao18;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class P6_1_Shuttle_BusTest {

    @Test
    void solution() {
        // given
        int n = 1;
        int t = 1;
        int m = 5;
        String[] timetable = {"08:00", "08:01", "08:02", "08:03"};

        String expected = "09:00";

        // when
        P6_1_Shuttle_Bus p6 = new P6_1_Shuttle_Bus();
        String answer = p6.solution(n, t, m, timetable);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }

    @Test
    void solution2() {
        // given
        int n = 2;
        int t = 1;
        int m = 2;
        String[] timetable = {"09:00", "09:00", "09:00", "09:00"};

        String expected = "08:59";

        // when
        P6_1_Shuttle_Bus p6 = new P6_1_Shuttle_Bus();
        String answer = p6.solution(n, t, m, timetable);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }

    @Test
    void solution3() {
        // given
        int n = 2;
        int t = 10;
        int m = 2;
        String[] timetable = {"09:10", "09:09", "08:00"};

        String expected = "09:09";

        // when
        P6_1_Shuttle_Bus p6 = new P6_1_Shuttle_Bus();
        String answer = p6.solution(n, t, m, timetable);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }

    @Test
    void solution4() {
        // given
        int n = 1;
        int t = 1;
        int m = 1;
        String[] timetable = {"23:59"};

        String expected = "09:00";

        // when
        P6_1_Shuttle_Bus p6 = new P6_1_Shuttle_Bus();
        String answer = p6.solution(n, t, m, timetable);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }

    @Test
    void solution5() {
        // given
        int n = 10;
        int t = 60;
        int m = 45;
        String[] timetable = {"23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59"};

        String expected = "18:00";

        // when
        P6_1_Shuttle_Bus p6 = new P6_1_Shuttle_Bus();
        String answer = p6.solution(n, t, m, timetable);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }


}
