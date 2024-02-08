package org.javaalgorithminterview.ch7_array;

import org.javaalgorithminterview.ch6_string.P1_1_Valid_Palindrome;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class P11_Valid_PalindromeTest {

    @Test
    @DisplayName("문자열을 대문자에서 소문자로 바꾼다.")
    void changeStringToLowerCase() {
        //given
        String s = "AbcD";

        //when & then
        assertThat(s.toLowerCase()).isEqualTo("abcd");
    }

    @Test
    @DisplayName("알파벳과 숫자가 아닌 문자를 제거한다.")
    void removeNonAlphabetChar() {
        // given
        String given = "A man, 0";
        String expected = "Aman0";

        // when
        String newStr = given.replaceAll("[^a-zA-Z0-9]", "");

        // then
        assertThat(newStr).isEqualTo(expected);
    }

    @Test
    @DisplayName("문자열을 뒤집는다")
    void reverseString() {
        //given
        String given = "abcde";
        String expected = "edcba";

        //when & then
        P1_1_Valid_Palindrome p1ValidPalindrome = new P1_1_Valid_Palindrome();

        assertThat(p1ValidPalindrome.reverseString(given)).isEqualTo(expected);
    }


    @Test
    @DisplayName("해당 문자열의 팰린드롬 여부를 검증한다")
    void isPalindrome() {
        // given
        String given = "A man, a plan, a canal: Panama";
        boolean expected = true;

        // when
        P1_1_Valid_Palindrome p1ValidPalindrome = new P1_1_Valid_Palindrome();
        boolean answer = p1ValidPalindrome.isPalindrome(given);


        // then
        assertThat(answer).isEqualTo(expected);
    }
}
