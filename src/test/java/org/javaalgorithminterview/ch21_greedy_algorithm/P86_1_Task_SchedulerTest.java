package org.javaalgorithminterview.ch21_greedy_algorithm;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class P86_1_Task_SchedulerTest {

    @Test
    void leastInterval() {
        // given
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 3;
        int expected = 10;

        // when
        P86_1_Task_Scheduler p86 = new P86_1_Task_Scheduler();
        int answer = p86.leastInterval(tasks, n);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }

    @Test
    void leastInterval2() {
        // given
        char[] tasks = {'A','A','A','B','B','B','C','D','E','F','G','H','I','J','K'};
        int n = 7;
        int expected = 18;

        // when
        P86_1_Task_Scheduler p86 = new P86_1_Task_Scheduler();
        int answer = p86.leastInterval(tasks, n);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }

}
