package org.javaalgorithminterview.ch22_divide_and_conquer;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class P89_1_Majority_ElementTest {

    @Test
    void majorityElement() {
        // given
        int[] nums = new int[]{2, 2, 1, 1, 1, 2, 2};
        int expected = 2;

        // when
        P89_1_Majority_Element p89 = new P89_1_Majority_Element();
        int answer = p89.majorityElement(nums);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }
}
