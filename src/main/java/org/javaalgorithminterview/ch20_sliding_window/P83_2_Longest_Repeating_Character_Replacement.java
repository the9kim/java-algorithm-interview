package org.javaalgorithminterview.ch20_sliding_window;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class P83_2_Longest_Repeating_Character_Replacement {
    public int characterReplacement(String s, int k) {
        int left = 0;
        Map<Character, Integer> counter = new HashMap<>();

        for (int right = 1; right <= s.length(); right++) {
            counter.put(s.charAt(right - 1), counter.getOrDefault(s.charAt(right - 1), 0) + 1);

            int maxCount = Collections.max(counter.values());

            if (right - left - maxCount > k) {
                counter.put(s.charAt(left), counter.get(s.charAt(left)) - 1);
                left++;
            }
        }
        return s.length() - left;
    }
}
