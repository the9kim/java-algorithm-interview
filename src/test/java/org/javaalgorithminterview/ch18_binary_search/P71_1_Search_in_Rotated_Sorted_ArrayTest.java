package org.javaalgorithminterview.ch18_binary_search;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P71_1_Search_in_Rotated_Sorted_ArrayTest {

    @Test
    void search() {
        // given
        int[] nums = new int[]{3, 4, 5, 6, 0, 1, 2};
        int target = 1;
        int expected = 5;

        // when
        P71_1_Search_in_Rotated_Sorted_Array p71 = new P71_1_Search_in_Rotated_Sorted_Array();
        int answer = p71.search(nums, target);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }
}
