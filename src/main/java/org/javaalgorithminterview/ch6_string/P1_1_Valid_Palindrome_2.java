package org.javaalgorithminterview.ch6_string;

public class P1_1_Valid_Palindrome_2 {

    public static void main(String[] arg) {
        String s = "A man, a plan, a canal: Panama";
    }

    /**
     * 문자 추출 및 비교
     * 1. 알파벳 또는 숫자 여부 검증
     * 2. 소문자 변환 후 일치 여부 검증
     */
    public boolean isPalindrome(String s) {

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            // 1. 알파벳 또는 숫자 여부 검증
            if (!Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            } else if (!Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            } else {
                // 2. 소문자 변환 후 일치 여부 검증
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false;
                }
                left++;
                right--;
            }
        }
        return true;
    }
}
