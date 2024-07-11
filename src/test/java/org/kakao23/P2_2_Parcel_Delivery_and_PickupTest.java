package org.kakao23;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P2_2_Parcel_Delivery_and_PickupTest {

    @Test
    void solution() {
        // given
        int cap = 4;
        int n = 5;
        int[] deliveries = {1, 0, 3, 1, 2};
        int[] pickups = {0, 3, 0, 4, 0};

        int expected = 16;

        // when
        P2_2_Parcel_Delivery_and_Pickup p2 = new P2_2_Parcel_Delivery_and_Pickup();
        long answer = p2.solution(cap, n, deliveries, pickups);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }

    @Test
    void solution2() {
        // given
        int cap = 2;
        int n = 7;
        int[] deliveries = {1, 0, 2, 0, 1, 0, 2};
        int[] pickups = {0, 2, 0, 1, 0, 2, 0};

        int expected = 30;

        // when
        P2_2_Parcel_Delivery_and_Pickup p2 = new P2_2_Parcel_Delivery_and_Pickup();
        long answer = p2.solution(cap, n, deliveries, pickups);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }


}
