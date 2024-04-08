package org.javaalgorithminterview.ch6_string;

public class P1_3_Valid_Palindrome {

    public boolean isPalindrome(String s) {

        // 1. Convert uppercase letters to lowercase letters
        s = s.toLowerCase();

        // 2. Remove non-alphanumeric characters
        s = s.replaceAll("[^a-z0-9]", "");

        // 3. Reversed the String
        String reversed = new StringBuilder(s).reverse().toString();

        return s.equals(reversed);
    }
}
