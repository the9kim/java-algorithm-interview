package org.javaalgorithminterview.ch6_string;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class P5_1_Group_AnagramsTest {

    @Test
    void groupAnagrams() {
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};

        List<List<String>> expected =
                List.of(
                        List.of("bat"),
                        List.of("nat", "tan"),
                        List.of("ate", "eat", "tea")
                );

        P5_1_Group_Anagrams p5 = new P5_1_Group_Anagrams();

        List<List<String>> answer = p5.groupAnagrams4(input);

        Assertions.assertThat(answer).isEqualTo(expected);
    }

    @Test
    void isAnagram() {
        // given
        String input1 = "eat";
        String input2 = "ate";

        // when
        P5_1_Group_Anagrams p5 = new P5_1_Group_Anagrams();

        boolean isAnagram = p5.isAnagram2(input1, input2);

        // then
        long start = System.currentTimeMillis();
        Assertions.assertThat(isAnagram).isTrue();
        long end = System.currentTimeMillis();
        System.out.printf("running time: %d", end - start);

    }

    @Test
    void isNotAnagram() {
        // given
        String input1 = "ddddddddddg";
        String input2 = "dgggggggggg";

        // when
        P5_1_Group_Anagrams p5 = new P5_1_Group_Anagrams();

        boolean isAnagram = p5.isAnagram(input1, input2);

        // then
        Assertions.assertThat(isAnagram).isFalse();
    }

    @Test
    void containsAll() {
        // given
        List<String> input1 = List.of("ate", "eat", "tea");
        List<String> input2 = List.of("eat", "tea");

        // when
        boolean hasContained = input1.containsAll(input2);

        // then
        Assertions.assertThat(hasContained).isTrue();
    }
}
