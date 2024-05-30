package org.kakao18;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P4_1_Friends_4BlocksTest {

    @Test
    void findBlocks() {
        // given
        int m = 6;
        int n = 6;
        String[] board = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};

        int expected = 15;

        // when
        P4_1_Friends_4Blocks p4 = new P4_1_Friends_4Blocks();
        int answer = p4.solution(m, n, board);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);

    }

    @Test
    void findBlocks2() {
        // given
        int m = 4;
        int n = 5;
        String[] board = {"CCBDE", "AAADE", "AAABF", "CCBBF"};

        int expected = 14;

        // when
        P4_1_Friends_4Blocks p4 = new P4_1_Friends_4Blocks();
        int answer = p4.solution(m, n, board);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);

    }
}
