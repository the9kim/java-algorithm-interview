package org.kakao21;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P7_1_Minimization_of_Sales_DeclineTest {

    @Test
    void solution() {
        // given
        int[] sales = {14, 17, 15, 18, 19, 14, 13, 16, 28, 17};
        int[][] links = {
                {10, 8},
                {1, 9},
                {9, 7},
                {5, 4},
                {1, 5},
                {5, 10},
                {10, 6},
                {1, 3},
                {10, 2}
        };
        int expected = 44;

        // when
        P7_1_Minimization_of_Sales_Decline p7 = new P7_1_Minimization_of_Sales_Decline();
        int answer = p7.solution(sales, links);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);

    }

    @Test
    void solution2() {
        // given
        int[] sales = {5, 6, 5, 3, 4};
        int[][] links = {
                {2, 3},
                {1, 4},
                {2, 5},
                {1, 2}
        };
        int expected = 6;

        // when
        P7_1_Minimization_of_Sales_Decline p7 = new P7_1_Minimization_of_Sales_Decline();
        int answer = p7.solution(sales, links);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);

    }
}
