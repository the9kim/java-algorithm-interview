package org.kakao20;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P4_2_Searching_LyricsTest {

    @Test
    void solution() {
        // given
        String[] words = new String[]{"frodo", "front", "frost", "frozen", "frame", "kakao"};
        String[] queries = new String[]{"fro??", "????o", "fr???", "fro???", "pro?"};

        int[] expected = new int[]{3, 2, 4, 1, 0};

        // when
        P4_2_Searching_Lyrics p4 = new P4_2_Searching_Lyrics();
        int[] answer = p4.solution(words, queries);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }

}
