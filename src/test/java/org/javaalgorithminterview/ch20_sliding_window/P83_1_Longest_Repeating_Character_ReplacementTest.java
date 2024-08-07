package org.javaalgorithminterview.ch20_sliding_window;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class P83_1_Longest_Repeating_Character_ReplacementTest {

    @Test
    void characterReplacement() {
        // given
        String s = "AAABBCD";
        int k = 2;
        int expected = 5;

        // when
        P83_1_Longest_Repeating_Character_Replacement p83 = new P83_1_Longest_Repeating_Character_Replacement();
        int answer = p83.characterReplacement(s, k);

        // then
        assertThat(answer).isEqualTo(expected);
    }

    @Test
    void characterReplacement2() {
        // given
        String s = "AAAA";
        int k = 2;
        int expected = 4;

        // when
        P83_1_Longest_Repeating_Character_Replacement p83 = new P83_1_Longest_Repeating_Character_Replacement();
        int answer = p83.characterReplacement(s, k);

        // then
        assertThat(answer).isEqualTo(expected);
    }

    @Test
    void characterReplacement3() {
        // given
        String s = "ABAA";
        int k = 0;
        int expected = 2;

        // when
        P83_1_Longest_Repeating_Character_Replacement p83 = new P83_1_Longest_Repeating_Character_Replacement();
        int answer = p83.characterReplacement(s, k);

        // then
        assertThat(answer).isEqualTo(expected);
    }

    @Test
    void characterReplacement4() {
        // given
        String s = "ABBB";
        int k = 2;
        int expected = 4;

        // when
        P83_1_Longest_Repeating_Character_Replacement p83 = new P83_1_Longest_Repeating_Character_Replacement();
        int answer = p83.characterReplacement(s, k);

        // then
        assertThat(answer).isEqualTo(expected);
    }
}
