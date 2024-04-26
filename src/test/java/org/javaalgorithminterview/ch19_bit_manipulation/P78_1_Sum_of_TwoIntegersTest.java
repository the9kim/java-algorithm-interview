package org.javaalgorithminterview.ch19_bit_manipulation;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class P78_1_Sum_of_TwoIntegersTest {

    @Test
    void changeIntToBitwiseString() {
        // given
        int n = 2;
        String expected =
                "0000000000" +
                        "0000000000" +
                        "0000000000" +
                        "10";

        // when
        String binary = String.format("%32s", Integer.toBinaryString(2)).replace(' ', '0');

        // then
        assertThat(binary).isEqualTo(expected);
    }

    @Test
    void changeBitwiseStringToInt() {
        // given
        String input =
                "0000000000" +
                        "0000000000" +
                        "0000000000" +
                        "10";
        int expected = 2;

        // when
        int answer = Integer.parseUnsignedInt(input, 2);

        // then
        System.out.println(answer);
    }
}
