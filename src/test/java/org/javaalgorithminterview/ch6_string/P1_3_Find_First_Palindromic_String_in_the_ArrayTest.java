package org.javaalgorithminterview.ch6_string;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class P1_3_Find_First_Palindromic_String_in_the_ArrayTest {


    @ParameterizedTest
    @DisplayName("팰린드롬이 성립한다.")
    @ValueSource(strings = {"ada", "racecar"})
    void isPalindrome(String s) {

        // given & when
        P1_3_Find_First_Palindromic_String_in_the_Array p1 = new P1_3_Find_First_Palindromic_String_in_the_Array();

        // then
        Assertions.assertThat(p1.isPalindrome(s)).isTrue();
    }

    @ParameterizedTest
    @DisplayName("팰린드롬이 성립하지 않는다.")
    @ValueSource(strings = {"abc", "car", "cool"})
    void isNotPalindrome(String s) {

        // given & when
        P1_3_Find_First_Palindromic_String_in_the_Array p1 = new P1_3_Find_First_Palindromic_String_in_the_Array();

        // then
        Assertions.assertThat(p1.isPalindrome(s)).isFalse();
    }
}
