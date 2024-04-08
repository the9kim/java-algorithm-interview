package org.javaalgorithminterview.ch6_string;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P1_3_Valid_PalindromeTest {

    @Test
    void isPalindrome() {
        // given
        String s = "race a car";
        P1_3_Valid_Palindrome p1 = new P1_3_Valid_Palindrome();

        // when
        boolean answer = p1.isPalindrome(s);

        // then
        Assertions.assertThat(answer).isFalse();
    }
}
