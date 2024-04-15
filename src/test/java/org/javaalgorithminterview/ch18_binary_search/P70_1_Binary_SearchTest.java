package org.javaalgorithminterview.ch18_binary_search;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class P70_1_Binary_SearchTest {

    @Test
    void binarySearch() {
        // given
        int[] nums = new int[]{-1, 0, 3, 5, 9, 12};
        int target = 9;
        int expected = 4;

        // when
        P70_1_Binary_Search p70 = new P70_1_Binary_Search();
        int answer = p70.search(nums, target);

        // then
        assertThat(answer).isEqualTo(expected);
    }
}
