package org.kakao21;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P2_1_Menu_RenewalTest {

    P2_1_Menu_Renewal p2;

    @BeforeEach
    void setUp() {
        p2 = new P2_1_Menu_Renewal();
    }



    @Test
    void menuRenewal() {
        // given
        String[] orders = new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = new int[]{2, 3, 4};
        String[] expected = new String[]{"AC", "ACDE", "BCFG", "CDE"};

        // when
        String[] answer = p2.solution(orders, course);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }

    @Test
    void menuRenewal2() {
        // given
        String[] orders = new String[]{"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
        int[] course = new int[]{2, 3, 5};
        String[] expected = new String[]{"ACD", "AD", "ADE", "CD", "XYZ"};

        // when
        String[] answer = p2.solution(orders, course);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }

    @Test
    void menuRenewal3() {
        // given
        String[] orders = new String[]{"XYZ", "XWY", "WXA"};
        int[] course = new int[]{2, 3, 4};
        String[] expected = new String[]{"WX", "XY"};

        // when
        String[] answer = p2.solution(orders, course);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }
}
