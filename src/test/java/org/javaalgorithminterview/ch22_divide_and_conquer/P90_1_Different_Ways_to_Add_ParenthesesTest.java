package org.javaalgorithminterview.ch22_divide_and_conquer;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

class P90_1_Different_Ways_to_Add_ParenthesesTest {

    @Test
    void diffWaysToCompute() {
        // given
        String expression = "2*3-4*5";
        List<Integer> expected = List.of(-34, -14, -10, -10, 10);

        // when
        P90_1_Different_Ways_to_Add_Parentheses p90 = new P90_1_Different_Ways_to_Add_Parentheses();
        List<Integer> answer = p90.diffWaysToCompute(expression);

        // then
        Assertions.assertThat(new HashSet(answer)).isEqualTo(new HashSet(expected));
    }
}
