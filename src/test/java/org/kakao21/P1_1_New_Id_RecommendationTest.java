package org.kakao21;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P1_1_New_Id_RecommendationTest {

    P1_1_New_Id_Recommendation problem;

    @BeforeEach
    void setUp() {
        this.problem = new P1_1_New_Id_Recommendation();
    }


    @Test
    void solution() {
        // given
        String new_id = "...!@BaT#*..y.abcdefghijklm";
        String expected = "bat.y.abcdefghi";

        // when
        P1_1_New_Id_Recommendation p1 = new P1_1_New_Id_Recommendation();
        String answer = p1.solution(new_id);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }

    @Test
    void solution2() {
        // given
        String new_id = "z-+.^.";
        String expected = "z--";

        // when
        P1_1_New_Id_Recommendation p1 = new P1_1_New_Id_Recommendation();
        String answer = p1.solution(new_id);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }

    @Test
    void solution3() {
        // given
        String new_id = "=.=";
        String expected = "aaa";

        // when
        P1_1_New_Id_Recommendation p1 = new P1_1_New_Id_Recommendation();
        String answer = p1.solution(new_id);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }

    @Test
    void solution4() {
        // given
        String new_id = "123_.def";
        String expected = "123_.def";

        // when
                P1_1_New_Id_Recommendation p1 = new P1_1_New_Id_Recommendation();
        String answer = p1.solution(new_id);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }

    @Test
    void solution5() {
        // given
        String new_id = "abcdefghijklmn.p";
        String expected = "abcdefghijklmn";

        // when
                P1_1_New_Id_Recommendation p1 = new P1_1_New_Id_Recommendation();
        String answer = p1.solution(new_id);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }

    @Test
    void replaceAll() {
        // given
        String input = "a9-._!";
        String expected = "a9-._";

        // when
        String pattern = "[^a-z0-9-_.]";
        String answer = input.replaceAll(pattern, "");

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }

    @Test
    void removeContinuousDots() {
        // given
        String input = "a...b..";
        String expected = "a.b.";

        // when
        String answer = input.replaceAll("\\.+", ".");

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }
}
