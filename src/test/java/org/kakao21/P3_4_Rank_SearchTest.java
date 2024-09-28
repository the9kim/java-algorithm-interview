package org.kakao21;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class P3_4_Rank_SearchTest {

    @Test
    void rankSearch() {
        // given
        String[] info = new String[]{
                "java backend junior pizza 150",
                "python frontend senior chicken 210",
                "python frontend senior chicken 150",
                "cpp backend senior pizza 260",
                "java backend junior chicken 80",
                "python backend senior chicken 50"};
        String[] query = new String[]{
                "java and backend and junior and pizza 100",
                "python and frontend and senior and chicken 200",
                "cpp and - and senior and pizza 250",
                "- and backend and senior and - 150",
                "- and - and - and chicken 100",
                "- and - and - and - 150"};
        int[] expected = new int[]{1, 1, 1, 1, 2, 4};

        // when
        P3_4_Rank_Search p3 = new P3_4_Rank_Search();
        int[] answer = p3.solution(info, query);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }

}
