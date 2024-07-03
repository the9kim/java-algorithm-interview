package org.kakao22;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class P3_1_Parking_Fee_CalculationTest {

    @Test
    void solution() {
        // given
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        int[] expected = {14600, 34400, 5000};

        // when
        P3_1_Parking_Fee_Calculation p3 = new P3_1_Parking_Fee_Calculation();
        int[] answer = p3.solution(fees, records);

        // then
        assertThat(answer).isEqualTo(expected);
    }
}
