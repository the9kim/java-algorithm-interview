package org.javaalgorithminterview.ch19_bit_manipulation;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class P77_1_Hamming_DistanceTest {

    @Test
    void hammingDistance() {
        // given
        int x = 4;
        int y = 1;
        int expected = 2;

        // when
        P77_1_Hamming_Distance p77 = new P77_1_Hamming_Distance();
        int answer = p77.hammingDistance(4, 1);

        // then
        assertThat(answer).isEqualTo(expected);
    }
}
