package org.javaalgorithminterview.ch20_sliding_window;

public class P82_1_Minimum_Window_Substring {
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
