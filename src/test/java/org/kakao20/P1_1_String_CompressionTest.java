package org.kakao20;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class P1_1_String_CompressionTest {

    @Test
    void stringCompression() {
        // given
        String s = "aabbaccc";
        int expected = 7;

        // when
        P1_1_String_Compression p1 = new P1_1_String_Compression();
        int answer = p1.solution(s);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }

    @Test
    void stringCompression2() {
        // given
        String s = "abcabcabcabcdededededede";
        int expected = 14;

        // when
        P1_1_String_Compression p1 = new P1_1_String_Compression();
        int answer = p1.solution(s);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }

    @Test
    void stringCompression3() {
        // given
        String s = "xababcdcdababcdcd";
        int expected = 17;

        // when
        P1_1_String_Compression p1 = new P1_1_String_Compression();
        int answer = p1.solution(s);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }

    @Test
    void stringCompression4() {
        // given
        String s = "a";
        int expected = 1;

        // when
        P1_1_String_Compression p1 = new P1_1_String_Compression();
        int answer = p1.solution(s);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }

    @Test
    void stringCompression5() {
        // given
        String s = "aabbaaaccc";
        int expected = 8;

        // when
        P1_1_String_Compression p1 = new P1_1_String_Compression();
        int answer = p1.solution(s);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }

    @Test
    void stringCompression6() {
        // given
        String s = "aaaaaaaaaabbbbbbbbbb";
        int expected = 6;

        // when
        P1_1_String_Compression p1 = new P1_1_String_Compression();
        int answer = p1.solution(s);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }
}
