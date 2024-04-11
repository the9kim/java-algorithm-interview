package org.javaalgorithminterview.ch17_sort;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class P68_1_Valid_AnagramTest {

    @Test
    void sortString() {
        // given
        String s = "anagram";
        String expected = "aaagmnr";

        // when
        P68_1_Valid_Anagram p68 = new P68_1_Valid_Anagram();
        String answer = p68.sortString(s);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }

    @Test
    void isAnagram() {
        // given
        String s = "anagram";
        String t = "nagaram";

        boolean expected = true;

        // when
        P68_1_Valid_Anagram p68 = new P68_1_Valid_Anagram();
        boolean answer = p68.isAnagram(s, t);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }
}
