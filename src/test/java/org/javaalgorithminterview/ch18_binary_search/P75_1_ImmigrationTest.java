package org.javaalgorithminterview.ch18_binary_search;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class P75_1_ImmigrationTest {

    @Test
    void immigration() {
        // given
        int[] times = new int[]{7, 10};
        int n = 6;
        int expected = 28;

        // when
        P75_1_Immigration p72 = new P75_1_Immigration();
        long minTime = p72.solution(n, times);

        // then
        assertThat(minTime).isEqualTo(expected);
    }

    @Test
    void immigration2() {
        // given
        int[] times = new int[]{4, 7, 10};
        int n = 8;
        int expected = 20;

        // when
        P75_1_Immigration p72 = new P75_1_Immigration();
        long minTime = p72.solution(n, times);

        // then
        assertThat(minTime).isEqualTo(expected);
    }
}
