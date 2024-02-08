package org.javaalgorithminterview.ch7_array;

import org.assertj.core.api.Assertions;
import org.javaalgorithminterview.ch7_array.P7_1_Two_Sum;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class P7_1_Two_SumTest {

    @Test
    void twoSum2() {
        // given
        int[] given = {3, 2, 3};
        int target = 6;
        int[] expected = {0, 2};

        // when
        P7_1_Two_Sum p7 = new P7_1_Two_Sum();
        int[] answer = p7.twoSum(given, target);

        // then
        Assertions.assertThat(answer).isNotEqualTo(expected);




    }

    @Test
    void binarySearch() {
        // given
        int[] intArr = {1, 2, 3, 4, 5};
        int element = 6;
        int expected = -(intArr.length + 1);

        // when
        int index = Arrays.binarySearch(intArr, element);

        // then
        Assertions.assertThat(index).isEqualTo(expected);

    }
}
