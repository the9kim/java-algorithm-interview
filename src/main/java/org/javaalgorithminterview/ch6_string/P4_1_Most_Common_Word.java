package org.javaalgorithminterview.ch6_string;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 1. change a given paragraph to lowercase.
 * 2. make String type Array type without non-alphanumeric words.
 * 3. count the number of words.
 * 4. check if the most frequent word is the banned word.
 * 5. return the most common word
 *
 * https://leetcode.com/problems/most-common-word/description/
 */
public class P4_1_Most_Common_Word {
    public static String mostCommonWord1(String paragraph, String[] banned) {

        // 1. 소문자 변환
        String input = paragraph.toLowerCase();

        // 2. 특수문자 제거
        input = input.replaceAll("[^a-z ]", " ");

        // 3. 배열 생성
        String[] inputArr = input.split("\\s+");

        // 4. CountMap 생성
        Map<String, Integer> countMap = new HashMap<>();

        List<String> bannedList = Arrays.asList(banned);

        for (String word : inputArr) {
            if (bannedList.contains(word)) {
                continue;
            }
            countMap.put(word, countMap.getOrDefault(word, 0) + 1);
        }

        // 5. commonWord 추출
        String commonWord = "";
        int frequency = -1;

        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() > frequency) {
                frequency = entry.getValue();
                commonWord = entry.getKey();
            }
        }

        return commonWord;
    }

    /**
     * A solution book suggests
     */
    public static String mostCommonWord2(String paragraph, String[] banned) {

        // A regex pattern '\W' matches non-characters
        String[] inputArr = paragraph.replaceAll("\\W", " ").toLowerCase().split("\\s+");

        // Why do I have to use set type instead of List?
        Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> count = new HashMap<>();

        for (String word : inputArr) {
            if (!bannedSet.contains(word)) {
                count.put(word, count.getOrDefault(word, 0) + 1);
            }
        }

        return Collections.max(count.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    /**
     * When I split a string which has more than two blanks, the resulting Array contains empty elements.
     */
    public static String mostCommonWord3(String paragraph, String[] banned) {

        String lowerCaseInput = paragraph.toLowerCase();

        String[] alphabeticArr = lowerCaseInput.split("[^a-z]");

        Map<String, Integer> countMap = new HashMap<>();

        List<String> bannedList = Arrays.asList(banned);
        for (String word : alphabeticArr) {
            if (bannedList.contains(word)) {
                continue;
            }
            countMap.put(word, countMap.getOrDefault(word, 0) + 1);
        }

        // 5. return the most common word
        int frequency = -1;
        String commonWord = "";
        for (Map.Entry<String, Integer> entrySet : countMap.entrySet()) {
            if (entrySet.getValue() > frequency) {
                frequency = entrySet.getValue();
                commonWord = entrySet.getKey();
            }
        }

        return commonWord;
    }
}
