package org.javaalgorithminterview.ch19_bit_manipulation;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class P79_1_UTF8_ValidationTest {

    @Test
    void validUtf8() {
        // given
        int[] data = new int[]{197, 130, 1};
        boolean expected = true;

        // when
        P79_1_UTF8_Validation p78 = new P79_1_UTF8_Validation();
        boolean answer = p78.validUtf8(data);

        // then
        assertThat(answer).isEqualTo(expected);
    }

    @Test
    void invalidUtf8() {
        // given
        int[] data = new int[]{235, 140, 4};
        boolean expected = false;

        // when
        P79_1_UTF8_Validation p78 = new P79_1_UTF8_Validation();
        boolean answer = p78.validUtf8(data);

        // then
        assertThat(answer).isEqualTo(expected);
    }

    @Test
    void invalidUtf8_2() {
        // given
        int[] data = new int[]{237};
        boolean expected = false;

        // when
        P79_1_UTF8_Validation p78 = new P79_1_UTF8_Validation();
        boolean answer = p78.validUtf8(data);

        // then
        assertThat(answer).isEqualTo(expected);
    }
}
