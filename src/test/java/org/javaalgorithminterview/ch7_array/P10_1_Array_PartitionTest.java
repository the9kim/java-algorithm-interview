package org.javaalgorithminterview.ch7_array;

import org.assertj.core.api.Assertions;
import org.javaalgorithminterview.ch7_array.P10_1_Array_Partition;
import org.junit.jupiter.api.Test;

class P10_1_Array_PartitionTest {

    @Test
    void arrayPairSum() {
        // given
        int[] given = {1, 4, 3, 2};
        int expected = 4;

        // when
        P10_1_Array_Partition p10 = new P10_1_Array_Partition();
        int answer = p10.arrayPairSum(given);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);

    }
}
