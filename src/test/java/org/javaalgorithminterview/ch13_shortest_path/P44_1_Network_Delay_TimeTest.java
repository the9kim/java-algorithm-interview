package org.javaalgorithminterview.ch13_shortest_path;

import org.junit.jupiter.api.Test;

class P44_1_Network_Delay_TimeTest {

    @Test
    void networkDelayTime() {
        // given
        int[][] times = {
                {3, 1, 5},
                {3, 2, 2},
                {2, 1, 2},
                {3, 4, 1},
                {4, 5, 1},
                {5, 6, 1},
                {6, 7, 1},
                {7, 8, 1},
                {8, 1, 1}
        };
        int n = 8;
        int k = 3;

        // when
        P44_1_Network_Delay_Time p44 = new P44_1_Network_Delay_Time();
        int answer = p44.networkDelayTime(times, n, k);

        // then
        System.out.println(answer);
    }
}
