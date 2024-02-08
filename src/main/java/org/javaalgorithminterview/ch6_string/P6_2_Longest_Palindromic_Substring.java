package org.javaalgorithminterview.ch6_string;

public class P6_2_Longest_Palindromic_Substring {

    public int left;
    public int length;


    public void extendPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        if (length < right - left - 1) {
            this.left = left + 1;
            this.length = right - left - 1;
        }
    }

    public String longestPalindrome(String s) {

        if (s.length() <= 1) {
            return s;
        }

        for (int i = 0; i < s.length() - 1; i++) {
            extendPalindrome(s, i, i + 1);
            extendPalindrome(s, i, i + 2);
        }

        return s.substring(left, left + length);
    }
}
