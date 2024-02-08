package org.javaalgorithminterview.ch6_string;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class P4_1_Most_Common_WordTest {


    @Test
    void mostCommonWord() {
        // given
        String given = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = {"hit"};
        String expected = "ball";

        // when
        String commonWord = P4_1_Most_Common_Word.mostCommonWord1(given, banned);

        // then
        Assertions.assertThat(commonWord).isEqualTo(expected);
    }

    @Test
    void removeSpecialSymbols() {
        // given
        String given = "Bob hit a ball, ";
        String expected = "bob hit a ball ";

        // when
        given = given.toLowerCase();
        String answer = given.replaceAll("[^a-z ]", "");

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }

    @Test
    void splitStringWithMoreThanTwoBlanks() {
        // given
        String given = "bob  hit a ball ";
        String[] expected = {"bob", "hit", "a", "ball"};

        // when
        String[] answer = given.split("\\s+");

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }

    @Test
    void splitStringWithNonAlphabeticDelimiter() {
        // given
        String given = "Bob hit a ball, ";
        String[] expected = {"bob", "hit", "a", "ball"};

        // when
        String lowerCase = given.toLowerCase();
        String[] lowerCaseArr = lowerCase.split("[^a-z]");

        // then
        Assertions.assertThat(lowerCaseArr).isEqualTo(expected);
    }

    @Test
    void countTheNumberOfSameWordsInArray() {
        // given
        String[] given = {"bob", "hit", "a", "ball", "bob"};
        Integer numberOfTheMostFrequentWord = 2;


        // when
        Map<String, Integer> countMap = new HashMap<>();

        for (String word : given) {
            countMap.put(word, countMap.getOrDefault(word, 0) + 1);
        }

        // then
        Assertions.assertThat(countMap.get("bob")).isEqualTo(2);
    }

    @Test
    void checkArrayContainsSpecificPrimitiveElement() {
        // given
        int[] given = {1, 2, 3, 4};
        int target = 3;

        // when
        int index = Arrays.binarySearch(given, target);

        // then

        // if index is under zero, the array doesn't contain the target element.
        Assertions.assertThat(index >= 0).isTrue();
    }

    @Test
    void checkArrayContainsSpecificNonPrimitiveElement() {
        // given
        String[] given = {"bob", "hit", "a", "ball", "bob"};
        String target = "bob";

        // when
        List<String> givenList = Arrays.asList(given);
        boolean hasTarget = givenList.contains(target);

        // then
        Assertions.assertThat(hasTarget).isTrue();
    }

    @Test
    void findTheMostCommonKeyInCountMap() {
        // given
        Map<String, Integer> countMap = Map.of(
                "bob", 2,
                "hit", 1,
                "a", 1,
                "ball", 3
        );

        String expected = "ball";

        // when
        String commonWord = "";
        Integer frequency = -1;

        for (Map.Entry<String, Integer> entrySet : countMap.entrySet()) {
            if (entrySet.getValue() > frequency) {
                frequency = entrySet.getValue();
                commonWord = entrySet.getKey();
            }
        }

        // then
        Assertions.assertThat(commonWord).isEqualTo(expected);
    }
}
