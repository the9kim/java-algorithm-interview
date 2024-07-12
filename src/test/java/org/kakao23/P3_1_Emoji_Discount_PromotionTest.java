package org.kakao23;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class P3_1_Emoji_Discount_PromotionTest {

    @Test
    void solution() {
        // given
        int[][] users = {{40, 10000}, {25, 10000}};
        int[] emoticons = {7000, 9000};
        int[] expected = {1, 5400};

        // when
        P3_1_Emoji_Discount_Promotion p3 = new P3_1_Emoji_Discount_Promotion();
        int[] answer = p3.solution(users, emoticons);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }

    @Test
    void getCombinations() {
        // given
        int[] emoticons = {7000, 9000};
        int[] rates = {10, 20, 30, 40};
        List<List<Integer>> combinations = new ArrayList<>();

        // when
        P3_1_Emoji_Discount_Promotion p3 = new P3_1_Emoji_Discount_Promotion();
        p3.getCombinations(combinations, emoticons, rates, new ArrayList<>());

        // then
        System.out.println(combinations);
    }
}
