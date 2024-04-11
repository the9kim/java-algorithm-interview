package org.javaalgorithminterview.ch17_sort;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class QuickSortTest {

    @Test
    void quickSort() {
        // given
        int[] nums = new int[]{38, 27, 43, 3, 9, 82, 10};
        QuickSort quickSort = new QuickSort();
        int[] expected = new int[]{3, 9, 10, 27, 38, 43, 82};

        // when
        int[] answer = quickSort.quickSort(nums, 0, nums.length - 1);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }
}
