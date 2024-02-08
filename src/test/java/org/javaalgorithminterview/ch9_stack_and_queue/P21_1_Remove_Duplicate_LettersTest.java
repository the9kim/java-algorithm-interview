
package org.javaalgorithminterview.ch9_stack_and_queue;

import org.assertj.core.api.Assertions;
import org.javaalgorithminterview.ch9_stack_and_queue.P21_1_Remove_Duplicate_Letters;
import org.junit.jupiter.api.Test;

class P21_1_Remove_Duplicate_LettersTest {

    @Test
    void removeDuplicateLetters() {

        // given
        String s = "cbacdcbc";
        String expected = "acdb";

        // when
        P21_1_Remove_Duplicate_Letters p21 = new P21_1_Remove_Duplicate_Letters();
        String answer = p21.removeDuplicateLetters4(s);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }

    @Test
    void removeDuplicateLetters2() {
        // given
        String s = "bcabc";
        String expected = "abc";

        // when
        P21_1_Remove_Duplicate_Letters p21 = new P21_1_Remove_Duplicate_Letters();
        String answer = p21.removeDuplicateLetters4(s);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }


    @Test
    void removeDuplicateLetters3() {
        // given
        String s = "rusrbofeggbbkyuyjsrzornpdguwzizqszpbicdquakqws";
        String expected = "bfegkuyjorndiqszpcaw";

        // when
        P21_1_Remove_Duplicate_Letters p21 = new P21_1_Remove_Duplicate_Letters();
        String answer = p21.removeDuplicateLetters4(s);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }
    @Test
    void compareAlOrder() {
        // given
        String s1 = "abcd";
        String s2 = "abdc";

        // when
        P21_1_Remove_Duplicate_Letters p21 = new P21_1_Remove_Duplicate_Letters();
        String answer = p21.compareLexicographicalOrder(s1, s2);

        // then
        Assertions.assertThat(answer).isEqualTo(s1);
    }

    @Test
    void compareAlOrder2() {
        // given
        String s1 = "abcd";
        String s2 = "abcd";

        // when
        P21_1_Remove_Duplicate_Letters p21 = new P21_1_Remove_Duplicate_Letters();
        String answer = p21.compareLexicographicalOrder(s1, s2);

        // then
        Assertions.assertThat(answer).isEqualTo(s1);
    }

    @Test
    void compareAlOrder3() {
        // given
        String s1 = "abcd";
        String s2 = "{";

        // when
        P21_1_Remove_Duplicate_Letters p21 = new P21_1_Remove_Duplicate_Letters();
        String answer = p21.compareLexicographicalOrder(s1, s2);

        // then
        Assertions.assertThat(answer).isEqualTo(s1);
    }
}


