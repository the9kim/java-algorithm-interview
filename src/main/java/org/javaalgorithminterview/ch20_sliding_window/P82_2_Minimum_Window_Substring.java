package org.javaalgorithminterview.ch20_sliding_window;

import java.util.HashMap;
import java.util.Map;

public class P82_2_Minimum_Window_Substring {

    /**
     * 1. Create a counter map which contains all necessary character
     * 2. Move a right pointer until a window contains all necessary characters.
     * 3. Keep Moving a fixed size window to the right
     * 4. Update the window size
     */
    public String minWindow(String s, String t) {

        // 1.
        Map<Character, Integer> counter = new HashMap<>();
        for (char c : t.toCharArray()) {
            counter.put(c, counter.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int right = 0;
        int start = 0;
        int end = 0;
        int missing = t.length();
        int minLen = Integer.MAX_VALUE;

        // 2.
        for (char c : s.toCharArray()) {
            right++;

            if (counter.containsKey(c) && counter.get(c) > 0) {
                missing--;
            }
            counter.put(c, counter.getOrDefault(c, 0) - 1);


            if (missing == 0) {
                while (left < right && counter.get(s.charAt(left)) < 0) {
                    counter.put(s.charAt(left), counter.getOrDefault(s.charAt(left), 0) + 1);
                    left++;
                }
                // 4.
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                    end = right;
                }

                // 3.
                counter.put(s.charAt(left), counter.getOrDefault(s.charAt(left), 0) + 1);
                missing++;
                left++;
            }
        }
        return s.substring(start, end);
    }
}
