package org.javaalgorithminterview.ch16_trie;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class P63_2_Palindrome_PairsTest {

    @Test
    void palindromePairs() {
        //given

        String[] words = {"d", "cbbcd", "dcbb", "dcbc", "cbbc", "bbcd"};
        List<List<Integer>> expected = List.of(
                List.of(0, 1),
                List.of(1, 4),
                List.of(2, 5),
                List.of(2, 1),
                List.of(3, 0),
                List.of(5, 2)
        );

        //when
        P63_2_Palindrome_Pairs p63 = new P63_2_Palindrome_Pairs();
        List<List<Integer>> answer = p63.palindromePairs(words);

        //then
        System.out.println(answer);
        assertThat(answer).isEqualTo(expected);
    }
}
