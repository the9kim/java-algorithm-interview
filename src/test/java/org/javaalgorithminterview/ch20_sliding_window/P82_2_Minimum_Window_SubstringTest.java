package org.javaalgorithminterview.ch20_sliding_window;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class P82_2_Minimum_Window_SubstringTest {

    @Test
    void minWindow() {
        // given
        String s = "ADOBECODEBANC";
        String t = "ABC";

        String expected = "BANC";

        // when
        P82_2_Minimum_Window_Substring p82 = new P82_2_Minimum_Window_Substring();
        String answer = p82.minWindow(s, t);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }

    @Test
    void minWindow2() {
        // given
        String s = "acbbaca";
        String t = "aba";

        String expected = "baca";

        // when
        P82_2_Minimum_Window_Substring p82 = new P82_2_Minimum_Window_Substring();
        String answer = p82.minWindow(s, t);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }
}
