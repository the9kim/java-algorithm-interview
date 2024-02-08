package org.javaalgorithminterview.ch9_stack_and_queue;

import org.assertj.core.api.Assertions;
import org.javaalgorithminterview.ch9_stack_and_queue.P22_1_Daily_Temperatures;
import org.junit.jupiter.api.Test;

class P22_1_Daily_TemperaturesTest {

    @Test
    void dailyTemperatures() {
        // given
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] expected = {1, 1, 4, 2, 1, 1, 0, 0};

        // when
        P22_1_Daily_Temperatures p22 = new P22_1_Daily_Temperatures();
        int[] answer = p22.dailyTemperatures(temperatures);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }
}
