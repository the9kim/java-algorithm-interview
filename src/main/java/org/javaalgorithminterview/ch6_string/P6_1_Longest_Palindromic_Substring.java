package org.javaalgorithminterview.ch6_string;

public class P6_1_Longest_Palindromic_Substring {


    /**
     * 1. extract substrings
     * 2. check if a substring is palindrome
     * 3. return the longest palindrome
     */
     public String longestPalindrome(String s) {

         for (int i = s.length(); i >= 1; i--) {
             for (int j = 0; i + j <= s.length(); j++) {
                 String subString = s.substring(j, j + i);
                 if (isPalindrome(subString)) {
                     return subString;
                 }
             }
         }
         return s;
    }

    /**
     * Time limit exceeded
     */
    public String longestPalindrome2(String s) {
        String longestPalindrome = "";

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String subString = s.substring(i, j);
                if (isPalindrome(subString) && subString.length() > longestPalindrome.length()) {
                    longestPalindrome = subString;
                }
            }
        }
        return longestPalindrome;
    }

    public boolean isPalindrome(String word) {
        int left = 0;
        int right = word.length() - 1;

        while (left < right) {
            if (word.charAt(left) != word.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
