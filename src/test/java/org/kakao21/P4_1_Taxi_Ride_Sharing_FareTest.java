package org.kakao21;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P4_1_Taxi_Ride_Sharing_FareTest {

    @Test
    void taxiFee() {
        // given
        int n = 6;
        int s = 4;
        int a = 6;
        int b = 2;
        int[][] fares = {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};
        int expected = 82;

        // when
        P4_1_Taxi_Ride_Sharing_Fare p4 = new P4_1_Taxi_Ride_Sharing_Fare();
        int answer = p4.solution(n, s, a, b, fares);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);

    }
}
