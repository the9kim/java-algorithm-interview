package org.javaalgorithminterview.ch20_sliding_window;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class P81_1_Sliding_Window_MaximumTest {

    @Test
    void maxSlidingWindow() {
        // given
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] expected = new int[]{3, 3, 5, 5, 6, 7};

        // when
        P81_1_Sliding_Window_Maximum p81 = new P81_1_Sliding_Window_Maximum();
        int[] answer = p81.maxSlidingWindow(nums, k);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }
}
