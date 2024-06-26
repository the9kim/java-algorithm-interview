package org.kakao19;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class P3_1_Candidate_KeyTest {

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
        P3_1_Candidate_Key p3 = new P3_1_Candidate_Key();
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
        P3_1_Candidate_Key p3 = new P3_1_Candidate_Key();
        int answer = p3.solution(relation);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }



    @Test
    void subsets() {
        // given
        String[] relation = new String[]{"a", "b", "c"};
        List<List<String>> answer = new ArrayList<>();
        List<List<String>> expected = List.of(
                Arrays.asList("0", "a"),
                Arrays.asList("01", "ab"),
                Arrays.asList("012", "abc"),
                Arrays.asList("02", "ac"),
                Arrays.asList("1", "b"),
                Arrays.asList("12", "bc"),
                Arrays.asList("2", "c")
        );


        // when
        P3_1_Candidate_Key p3 = new P3_1_Candidate_Key();

        p3.subsets(answer, new StringBuilder(), new StringBuilder(), relation, 0);

        // then
        System.out.println(answer);
        Assertions.assertThat(answer).isEqualTo(expected);
    }

    @Test
    void subsets2() {
        // given
        String[] relation = new String[]{"100", "ryan", "music", "2"};
        List<List<String>> answer = new ArrayList<>();


        // when
        P3_1_Candidate_Key p3 = new P3_1_Candidate_Key();

        p3.subsets(answer, new StringBuilder(), new StringBuilder(), relation, 0);

        // then
        System.out.println(answer);
    }
}
