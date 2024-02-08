package org.javaalgorithminterview.ch6_string;

public class P1_3_Find_First_Palindromic_String_in_the_Array {

    /**
     * 1. 배열의 요소를 순차적으로 조회한다
     * 2. 요소의 팰린드롬 여부를 검증한다
     *  2-1. (참일 경우) 해당 요소를 반환한다.
     *  2-2. (거짓일 경우) 다음 요소로 넘어간다.
     * 3. 팰린드롬인 요소가 하나도 없을 경우 빈 문자열을 반환한다.
     */
    public String firstPalindrome(String[] words) {

        for (String word : words) {
            if (isPalindrome(word)) {
                return word;
            }
        }
        return "";
    }

    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
