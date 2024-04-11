package org.javaalgorithminterview.ch17_sort;

import java.util.Arrays;

public class P68_1_Valid_Anagram {

    /**
     * 1. Transfer each input String to character array
     * 2. Sort each character array
     * 3. Convert the character arrays to the String type
     */
    public boolean isAnagram(String s,  String t) {
        return sortString(s).equals(sortString(t));
    }

    public String sortString(String s) {
        char[] sArr = s.toCharArray();
        Arrays.sort(sArr);
        return new String(sArr);
    }
}
