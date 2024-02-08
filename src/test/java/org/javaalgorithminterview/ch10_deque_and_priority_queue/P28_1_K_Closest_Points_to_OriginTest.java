package org.javaalgorithminterview.ch10_deque_and_priority_queue;

import org.javaalgorithminterview.ch10_deque_and_priority_queue.P28_1_K_Closest_Points_to_Origin;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.SoftAssertions;

class P28_1_K_Closest_Points_to_OriginTest {

    @Test
    void kClosest() {
        // given
        P28_1_K_Closest_Points_to_Origin p28 = new P28_1_K_Closest_Points_to_Origin();

        int[][] points = {{-5, 4}, {-6, -5}, {4, 6}};
        int k = 2;

        int[][] expected = {{-5, 4}, {4, 6}};

        // when
        int[][] answer = p28.kClosest(points, 2);

        SoftAssertions.assertSoftly(softly -> {
                    softly.assertThat(answer).isEqualTo(expected);
                }
        );

    }

    @Test
    void kClosest2() {
        // given
        P28_1_K_Closest_Points_to_Origin p28 = new P28_1_K_Closest_Points_to_Origin();

        int[][] points = {{3, 3}, {5, -1}, {-2, 4}};
        int k = 2;

        int[][] expected = {{3, 3}, {-2, 4}};

        // when
        int[][] answer = p28.kClosest(points, 2);

        SoftAssertions.assertSoftly(softly -> {
                    softly.assertThat(answer).isEqualTo(expected);
                }
        );

    }

}
