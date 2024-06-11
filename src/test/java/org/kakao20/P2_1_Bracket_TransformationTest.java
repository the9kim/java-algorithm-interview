package org.kakao20;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P2_1_Bracket_TransformationTest {

    @Test
    void solution1() {
        // given
        String p = "()))((()";
        String expected = "()(())()";

        // when
        P2_1_Bracket_Transformation p2 = new P2_1_Bracket_Transformation();
        String answer = p2.solution(p);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }

    @Test
    void solution2() {
        // given
        String p = "";
        String expected = "";

        // when
        P2_1_Bracket_Transformation p2 = new P2_1_Bracket_Transformation();
        String answer = p2.solution(p);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }

    @Test
    void solution3() {
        // given
        String p = ")()(()";
        String expected = "((()))";

        // when
        P2_1_Bracket_Transformation p2 = new P2_1_Bracket_Transformation();
        String answer = p2.solution(p);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }

    @Test
    void splitInputString() {
        // given
        String p = "))((()";
        String expectedLeft = "))((";
        String expectedRight = "()";

        // when
        P2_1_Bracket_Transformation p2 = new P2_1_Bracket_Transformation();
        int idx = p2.findSplitPoint(p);

        // then
        Assertions.assertThat(p.substring(0, idx)).isEqualTo(expectedLeft);
        Assertions.assertThat(p.substring(idx)).isEqualTo(expectedRight);

    }

    @Test
    void splitInputString2() {
        // given
        String p = "()";
        String expectedLeft = "()";
        String expectedRight = "";

        // when
        P2_1_Bracket_Transformation p2 = new P2_1_Bracket_Transformation();
        int idx = p2.findSplitPoint(p);

        // then
        Assertions.assertThat(p.substring(0, idx)).isEqualTo(expectedLeft);
        Assertions.assertThat(p.substring(idx)).isEqualTo(expectedRight);

    }

    @Test
    void isValid() {
        // given
        String s = "()()";
        boolean expected = true;

        // when
        P2_1_Bracket_Transformation p2 = new P2_1_Bracket_Transformation();
        boolean answer = p2.isValid(s);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }

    @Test
    void isValid2() {
        // given
        String s = "(())";
        boolean expected = true;

        // when
        P2_1_Bracket_Transformation p2 = new P2_1_Bracket_Transformation();
        boolean answer = p2.isValid(s);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }

    @Test
    void isValid3() {
        // given
        String s = "";
        boolean expected = true;

        // when
        P2_1_Bracket_Transformation p2 = new P2_1_Bracket_Transformation();
        boolean answer = p2.isValid(s);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }

    @Test
    void isValid4() {
        // given
        String s = "(()())()";
        boolean expected = true;

        // when
        P2_1_Bracket_Transformation p2 = new P2_1_Bracket_Transformation();
        boolean answer = p2.isValid(s);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }

    @Test
    void isNotValid() {
        // given
        String s = "))((";
        boolean expected = false;

        // when
        P2_1_Bracket_Transformation p2 = new P2_1_Bracket_Transformation();
        boolean answer = p2.isValid(s);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }

    @Test
    void isNotValid2() {
        // given
        String s = "())(";
        boolean expected = false;

        // when
        P2_1_Bracket_Transformation p2 = new P2_1_Bracket_Transformation();
        boolean answer = p2.isValid(s);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }

}
