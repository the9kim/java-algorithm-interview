package org.javaalgorithminterview.ch6_string;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class P6_1_Longest_Palindromic_SubstringTest {

    @Test
    void longestPalindrome() {
        // given
        String given = "babad";
        String expected = "bab";

        // when
        P6_1_Longest_Palindromic_Substring p6 = new P6_1_Longest_Palindromic_Substring();
        String answer = p6.longestPalindrome(given);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }

    @Test
    void isPalindrome() {
        // given
        String given = "bab";
        boolean answer = true;

        // when
        int left = 0;
        int right = given.length() - 1;

        while (left < right) {
            if (given.charAt(left) != given.charAt(right)) {
                answer = false;
                break;
            }
            left++;
            right--;
        }

        // then
        Assertions.assertThat(answer).isTrue();
    }
}
