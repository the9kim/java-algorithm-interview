package org.javaalgorithminterview.ch11_hash_table;

import java.util.HashMap;
import java.util.Map;

public class P32_1_Longest_Substring_Without_Repeating_Characters {

    /**
     * The solution provided in the book involves utilizing sliding window and two pointers.
     */
    public int lengthOfLongestSubstring0(String s) {
        Map<Character, Integer> used = new HashMap<>();

        int left = 0;
        int right = 0;
        int length = 0;

        for (char c : s.toCharArray()) {
            if (used.containsKey(c) && left <= used.get(c)) {
                left = used.get(c) + 1;
            }
            used.put(c, right);
            length = Math.max(length, right - left + 1);
            right++;
        }
        return length;
    }

    /**
     * Update the length of the longest substring using brute Force.
     */
    public int lengthOfLongestSubstring(String s) {
        String answer = "";

        Map<Character, Integer> freqs = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            String sub = s.substring(i);
            freqs = new HashMap<>();
            sb = new StringBuilder();
            for (char c : sub.toCharArray()) {
                if (freqs.containsKey(c)) {
                    if (sb.toString().length() > answer.length()) {
                        answer = sb.toString();
                    }
                    break;
                }
                sb.append(c);
                freqs.put(c, freqs.getOrDefault(c, 0));
            }
            if (sb.toString().length() > answer.length()) {
                answer = sb.toString();
            }
        }
        return answer.length();
    }

    /**
     * 1. Utilize Character Array and calculate frequency of characters.
     * 2. Calculate the length of substring without repeating characters.
     *
     * This solution can't handle the input(s = "dvdf");
     */
    public int lengthOfLongestSubstring2(String s) {
        String answer = "";

        Map<Character, Integer> freqs = new HashMap<>();

        StringBuilder sb = new StringBuilder();
        for (Character c : s.toCharArray()) {
            if (!freqs.containsKey(c)) {
                sb.append(c);
            } else if (freqs.containsKey(c)) {
                if (sb.toString().length() > answer.length()) {
                    answer = sb.toString();
                }
                freqs = new HashMap<>();
                sb = new StringBuilder();
                sb.append(c);
            }
            freqs.put(c, freqs.getOrDefault(c, 0) + 1);
        }
        if (sb.toString().length() > answer.length()) {
            answer = sb.toString();
        }
        return answer.length();
    }


}
