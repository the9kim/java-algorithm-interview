package org.javaalgorithminterview.ch18_binary_search;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class P73_1_Two_SumTest {

    @Test
    void twoSum() {
        // given
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] expected = new int[]{1, 2};

        // when
        P73_1_Two_Sum p73 = new P73_1_Two_Sum();
        int[] answer = p73.twoSum(nums, target);

        // then
        assertThat(answer).isEqualTo(expected);
    }
}
