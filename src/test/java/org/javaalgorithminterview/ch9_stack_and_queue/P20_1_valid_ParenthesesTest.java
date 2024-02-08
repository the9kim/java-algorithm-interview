package org.javaalgorithminterview.ch9_stack_and_queue;

import org.assertj.core.api.Assertions;
import org.javaalgorithminterview.ch9_stack_and_queue.P20_1_Valid_Parentheses;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class P20_1_valid_ParenthesesTest {

    @ParameterizedTest
    @ValueSource(strings = {"()[]{}", "[{()}]"})
    void isValid(String s) {
        // given
        boolean expected = true;

        // when
        P20_1_Valid_Parentheses p20 = new P20_1_Valid_Parentheses();
        boolean answer = p20.isValid(s);

        // then
        Assertions.assertThat(expected).isEqualTo(answer);
    }

}
