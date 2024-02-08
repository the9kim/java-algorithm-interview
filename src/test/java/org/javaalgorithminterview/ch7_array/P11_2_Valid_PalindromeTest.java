package org.javaalgorithminterview.ch7_array;

import org.javaalgorithminterview.ch6_string.P1_1_Valid_Palindrome_2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class P11_2_Valid_PalindromeTest {

    @ParameterizedTest
    @ValueSource(strings = {"A man, a plan, a canal: Panama", ".,"})
    @DisplayName("해당 문자열의 팰린드롬 여부를 검증한다")
    void isPalindrome(String s) {
        // given
        boolean expected = true;

        // when
        P1_1_Valid_Palindrome_2 p2ValidPalindrome = new P1_1_Valid_Palindrome_2();
        boolean answer = p2ValidPalindrome.isPalindrome(s);

        // then
        assertThat(answer).isEqualTo(expected);
    }
}
