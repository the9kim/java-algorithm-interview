package org.kakao22;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class P4_2_Archery_TournamentTest {

    @Test
    void solution() {
        // given
        int n = 5;
        int[] info = {2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0};
        int[] expected = {0, 2, 2, 0, 1, 0, 0, 0, 0, 0, 0};

        // when
        P4_2_Archery_Tournament p4 = new P4_2_Archery_Tournament();
        int[] answer = p4.solution(n, info);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }

    @Test
    void solution2() {
        // given
        int n = 10;
        int[] info = {0, 0, 0, 0, 0, 0, 0, 0, 3, 4, 3};
        int[] expected = {1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 2};

        // when
        P4_2_Archery_Tournament p4 = new P4_2_Archery_Tournament();
        int[] answer = p4.solution(n, info);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }

    @Test
    void solution3() {
        // given
        int n = 1;
        int[] info = {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] expected = {-1};

        // when
        P4_2_Archery_Tournament p4 = new P4_2_Archery_Tournament();
        int[] answer = p4.solution(n, info);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }

    @Test
    void getCombinationWithRepetition() {
        // given
        int n = 3;

        // when
        P4_2_Archery_Tournament p4 = new P4_2_Archery_Tournament();
        List<List<Integer>> combinations = new ArrayList<>();
        p4.getCombinationWithRepetition(combinations, 3, new ArrayList<>(), 0);

        System.out.println(combinations);
    }
}
