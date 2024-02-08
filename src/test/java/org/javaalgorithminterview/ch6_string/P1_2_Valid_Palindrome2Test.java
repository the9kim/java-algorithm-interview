package org.javaalgorithminterview.ch6_string;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class P1_2_Valid_Palindrome2Test {

    @ParameterizedTest
    @ValueSource(strings = {"aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga",
            "ebcbbececabbacecbbcbe",
            "cbbcc", "aba", "abcca", "abca"})
    @DisplayName("한 문자를 빼면 팰린드롭이 성립한다.")
    public void validPalindrome(String s) {
        // given & when
        P1_2_Valid_Palindrome2 p1 = new P1_2_Valid_Palindrome2();

        // then
        Assertions.assertThat(p1.validPalindrome(s)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"abddebca", "abc", "abdca"})
    @DisplayName("한 문자를 빼도 팰린드롭이 성립하지 않는다.")
    public void validWrongPalindrome(String s) {
        // given & when
        P1_2_Valid_Palindrome2 p1 = new P1_2_Valid_Palindrome2();

        // then
        Assertions.assertThat(p1.validPalindrome(s)).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"bccb", "aba"})
    @DisplayName("부분 문자열의 팰린드롬이 성립한다.")
    void isPalindrome(String s) {
        // given
        P1_2_Valid_Palindrome2 p1 = new P1_2_Valid_Palindrome2();

        // when & then
        Assertions.assertThat(p1.isPalindrome(s)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"bccba", "baba"})
    @DisplayName("부분 문자열의 팰린드롬이 성립한다..")
    void isNotPalindrome(String s) {
        // given
        P1_2_Valid_Palindrome2 p1 = new P1_2_Valid_Palindrome2();

        // when & then
        Assertions.assertThat(p1.isPalindrome(s)).isFalse();
    }

}
