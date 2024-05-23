package org.javaalgorithminterview.ch23_dynamic_programming;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P94_2_House_RobberTest {

    @Test
    void rob() {
        // given
        int[] nums = {2, 7, 9, 3, 1};
        int expected = 12;

        // when
        P94_2_House_Robber p94 = new P94_2_House_Robber();
        int answer = p94.rob(nums);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }

}
