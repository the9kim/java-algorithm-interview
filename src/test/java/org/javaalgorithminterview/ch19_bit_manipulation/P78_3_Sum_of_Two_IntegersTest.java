package org.javaalgorithminterview.ch19_bit_manipulation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class P78_3_Sum_of_Two_IntegersTest {

    @Test
    void getSum() {
        // given
        int a = 1;
        int b = 2;
        int expected = 3;

        // when
        P78_3_Sum_of_Two_Integers p78 = new P78_3_Sum_of_Two_Integers();
        int answer = p78.getSum(a, b);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);


    }

    @Test
    void getSum2() {
        // given
        int a = 2;
        int b = 3;
        int expected = 5;

        // when
        P78_3_Sum_of_Two_Integers p78 = new P78_3_Sum_of_Two_Integers();
        int answer = p78.getSum(a, b);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }

    @Test
    void getSum3() {
        // given
        int a = -12;
        int b = -8;
        int expected = -20;

        // when
        P78_3_Sum_of_Two_Integers p78 = new P78_3_Sum_of_Two_Integers();
        int answer = p78.getSum(a, b);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }
}
