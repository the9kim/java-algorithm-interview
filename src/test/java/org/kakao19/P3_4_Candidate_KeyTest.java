package org.kakao19;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class P3_4_Candidate_KeyTest {

    @Test
    void candidateKey() {
        // given
        String[][] relation = {
                {"100", "ryan", "music", "2"},
                {"200", "apeach", "math", "2"},
                {"300", "tube", "computer", "3"},
                {"400", "con", "computer", "4"},
                {"500", "muzi", "music", "3"},
                {"600", "apeach", "music", "2"}
        };
        int expected = 2;

        // when
        P3_4_Candidate_Key p3 = new P3_4_Candidate_Key();
        int answer = p3.solution(relation);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }

    @Test
    void candidateKey2() {
        // given
        String[][] relation = {
                {"100", "100", "ryan", "music", "2"},
                {"200", "200", "apeach", "math", "2"},
                {"300", "300", "tube", "computer", "3"},
                {"400", "400", "con", "computer", "4"},
                {"500", "500", "muzi", "music", "3"},
                {"600", "600", "apeach", "music", "2"}
        };

        int expected = 3;

        // when
        P3_4_Candidate_Key p3 = new P3_4_Candidate_Key();
        int answer = p3.solution(relation);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }

}
