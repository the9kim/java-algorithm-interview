package org.kakao18;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P7_2_Thanksgiving_TrafficTest {

    @Test
    void solution() {
        // given
        String[] lines = {
                "2016-09-15 20:59:57.421 0.351s",
                "2016-09-15 20:59:58.233 1.181s",
                "2016-09-15 20:59:58.299 0.8s",
                "2016-09-15 20:59:58.688 1.041s",
                "2016-09-15 20:59:59.591 1.412s",
                "2016-09-15 21:00:00.464 1.466s",
                "2016-09-15 21:00:00.741 1.581s",
                "2016-09-15 21:00:00.748 2.31s",
                "2016-09-15 21:00:00.966 0.381s",
                "2016-09-15 21:00:02.066 2.62s"
        };
        int expected = 7;

        // when
        P7_2_Thanksgiving_Traffic p7 = new P7_2_Thanksgiving_Traffic();
        int answer = p7.solution(lines);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }

    @Test
    void solution2() {
        // given
        String[] lines = {
                "2016-09-15 01:00:04.002 2.0s",
                "2016-09-15 01:00:07.000 2s"
        };
        int expected = 2;

        // when
        P7_2_Thanksgiving_Traffic p7 = new P7_2_Thanksgiving_Traffic();
        int answer = p7.solution(lines);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }

    @Test
    void solution3() {
        // given
        String[] lines = {
                "2016-09-15 01:00:04.001 2.0s",
                "2016-09-15 01:00:07.000 2s"};
        int expected = 1;

        // when
        P7_2_Thanksgiving_Traffic p7 = new P7_2_Thanksgiving_Traffic();
        int answer = p7.solution(lines);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }




}
