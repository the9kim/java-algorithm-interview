package org.javaalgorithminterview.ch21_greedy_algorithm;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class P87_1_Gas_StationTest {

    @Test
    void canCompleteCircuit() {
        // given
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};

        int expected = 3;

        // when
        P87_1_Gas_Station p87 = new P87_1_Gas_Station();
        int answer = p87.canCompleteCircuit(gas, cost);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }

    @Test
    void canCompleteCircuit2() {
        // given
        int[] gas = {2, 3, 4};
        int[] cost = {3, 4, 3};

        int expected = -1;

        // when
        P87_1_Gas_Station p87 = new P87_1_Gas_Station();
        int answer = p87.canCompleteCircuit(gas, cost);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }
}
