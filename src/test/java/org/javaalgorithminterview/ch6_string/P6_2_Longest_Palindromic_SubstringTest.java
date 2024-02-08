package org.javaalgorithminterview.ch6_string;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class P6_2_Longest_Palindromic_SubstringTest {

    @Test
    void extendPalindrome() {
        // given
        String s = "dcbbcd";
        int left = 2;
        int right = 3;


        // when
        P6_2_Longest_Palindromic_Substring p6 = new P6_2_Longest_Palindromic_Substring();
        p6.extendPalindrome(s, left, right);

        // then
        Assertions.assertThat(p6.left).isEqualTo(0);
        Assertions.assertThat(p6.length).isEqualTo(s.length());
    }

    @Test
    void longestPalindrome() {
        // given
        String given = "babad";
        String expected = "bab";

        // when
        P6_2_Longest_Palindromic_Substring p6 = new P6_2_Longest_Palindromic_Substring();
        String answer = p6.longestPalindrome(given);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }
}
