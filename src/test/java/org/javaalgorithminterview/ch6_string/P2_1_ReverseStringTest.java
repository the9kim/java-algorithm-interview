package org.javaalgorithminterview.ch6_string;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class P2_1_ReverseStringTest {

    @Test
    @DisplayName("문자 배열의 순서를 뒤집는데 성공한다.")
    void reverseString() {
        // given
        char[] given = {'h', 'e', 'l', 'l', 'o'};
        char[] expected = {'o', 'l', 'l', 'e', 'h'};

        // when
        P2_1_ReverseString.reverseString(given);

        // when & then
        Assertions.assertThat(given).isEqualTo(expected);
    }
}
