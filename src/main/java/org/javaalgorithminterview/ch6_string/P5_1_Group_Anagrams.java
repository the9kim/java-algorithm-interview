package org.javaalgorithminterview.ch6_string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P5_1_Group_Anagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Set<List<String>> answer = new HashSet();

        for (String word1 : strs) {
            List<String> tempList = new ArrayList<>();
            for (String word2 : strs) {
                if (isAnagram(word1, word2)) {
                    tempList.add(word2);
                }
            }
            answer.add(tempList);
        }
        return new ArrayList<>(answer);
    }


    public List<List<String>> groupAnagrams2(String[] strs) {
        List<List<String>> answer = new ArrayList<>();

        for (int i = 0; i < strs.length; i++) {
            List<String> tempList = new ArrayList<>();

            for (int j = i; j < strs.length; j++) {
                if (isAnagram(strs[i], strs[j])) {
                    tempList.add(strs[j]);
                }
            }
            if (isNotContained(answer, tempList)) {
                answer.add(tempList);
            }
        }
        return answer;
    }

    public List<List<String>> groupAnagrams3(String[] strs) {
        List<List<String>> answer = new ArrayList<>();

        for (int i = 0; i < strs.length; i++) {
            List<String> tempList = new ArrayList<>();
            if (isContained(answer, strs[i])) {
                continue;
            }
            for (int j = i; j < strs.length; j++) {
                if (isAnagram(strs[i], strs[j])) {
                    tempList.add(strs[j]);
                }
            }
        }

        return answer;
    }

    public List<List<String>> groupAnagrams4(String[] strs) {
        List<List<String>> answer = new ArrayList<>();

        List<String> input = new ArrayList<>(Arrays.asList(strs));

        while (input.size() > 0) {
            List<String> group = new ArrayList();
            String firstWord = input.get(0);

            for (String word : input) {
                if (isAnagram(firstWord, word)) {
                    group.add(word);
                }
            }
            answer.add(group);
            input.removeAll(group);
        }
        return answer;
    }

    /**
     * 1. sort two string params
     * 2. compare the strings
     */
    public boolean isAnagram2(String s1, String s2) {
        List<String> lst1 = new ArrayList<>(Arrays.asList(s1.split("")));
        List<String> lst2 = new ArrayList<>(Arrays.asList(s2.split("")));

        Collections.sort(lst1);
        Collections.sort(lst2);

        return lst1.equals(lst2);
    }

    public boolean isAnagram(String s1, String s2) {
        char[] s1Array = s1.toCharArray();
        char[] s2Array = s2.toCharArray();

        Arrays.sort(s1Array);
        Arrays.sort(s2Array);

        return new String(s1Array).equals(new String(s2Array));
    }

    public boolean isNotContained(List<List<String>> answer, List<String> tempGroup) {
        for (List<String> group : answer) {
            if (group.containsAll(tempGroup)) {
                return false;
            }
        }
        return true;
    }

    public boolean isContained(List<List<String>> answer, String word) {
        for (List<String> group : answer) {
            if (group.contains(word)) {
                return true;
            }
        }
        return false;
    }
}
