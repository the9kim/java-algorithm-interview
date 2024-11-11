package org.kakao23;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class P4_3_Representable_Binary_TreeTest {
    @Test
    void solution() {
        // given
        long[] numbers = {7, 42, 5};
        int[] expected = {1, 1, 0};

        // when
        P4_3_Representable_Binary_Tree p4 = new P4_3_Representable_Binary_Tree();
        int[] answer = p4.solution(numbers);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }

    @Test
    void solution2() {
        // given
        long[] numbers = {63, 111, 95};
        int[] expected = {1, 1, 0};

        // when
        P4_3_Representable_Binary_Tree p4 = new P4_3_Representable_Binary_Tree();
        int[] answer = p4.solution(numbers);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }


}
