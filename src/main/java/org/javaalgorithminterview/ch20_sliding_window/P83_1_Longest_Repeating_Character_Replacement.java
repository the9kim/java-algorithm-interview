package org.javaalgorithminterview.ch20_sliding_window;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class P83_1_Longest_Repeating_Character_Replacement {
    public String minWindow(String s, String t) {

        for (int windowSize = t.length(); windowSize < s.length() + 1; windowSize++) {
            for (int left = 0; left < s.length() - windowSize + 1; left++) {
                String subS = s.substring(left, left + windowSize);
                if (contains(subS, t)) {
                    return subS;
                }
            }
        }
        return "";
    }

    public boolean contains(String s, String t) {
        StringBuilder sb = new StringBuilder(s);

        for (char c : t.toCharArray()) {
            if (sb.indexOf(String.valueOf(c)) != -1) {
                sb.deleteCharAt(sb.indexOf(String.valueOf(c)));
            } else {
                return false;
            }
        }
        return true;
    }
}
