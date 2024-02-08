package org.javaalgorithminterview.ch7_array;

import org.assertj.core.api.Assertions;
import org.javaalgorithminterview.ch7_array.P8_2_Trapping_Rain_Water;
import org.junit.jupiter.api.Test;

class P8_2_Trapping_Rain_WaterTest {

    @Test
    void trap() {
        // given
        int[] height = {0, 1, 0, 2};
        int expected = 1;

        // when
        P8_2_Trapping_Rain_Water p8 = new P8_2_Trapping_Rain_Water();
        int answer = p8.trap(height);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }

    @Test
    void trap2() {
        // given
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3};
        int expected = 5;

        // when
        P8_2_Trapping_Rain_Water p8 = new P8_2_Trapping_Rain_Water();
        int answer = p8.trap(height);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }

    @Test
    void trap3() {
        // given
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int expected = 6;

        // when
        P8_2_Trapping_Rain_Water p8 = new P8_2_Trapping_Rain_Water();
        int answer = p8.trap(height);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }

    @Test
    void trap4() {
        // given
        int[] height = {6, 8, 5, 0, 0, 6, 5};
        int expected = 13;

        // when
        P8_2_Trapping_Rain_Water p8 = new P8_2_Trapping_Rain_Water();
        int answer = p8.trap(height);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }

    @Test
    void trap5() {
        // given
        int[] height = {5, 4, 1, 2};
        int expected = 1;

        // when
        P8_2_Trapping_Rain_Water p8 = new P8_2_Trapping_Rain_Water();
        int answer = p8.trap(height);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }

}
