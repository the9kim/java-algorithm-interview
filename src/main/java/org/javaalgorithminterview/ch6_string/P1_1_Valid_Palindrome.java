package org.javaalgorithminterview.ch6_string;

public class P1_1_Valid_Palindrome {

    public static void main(String[] arg) {
        String s = "A man, a plan, a canal: Panama";

    }

    /** 문자열 전체 비교
     * 1. 대문자 -> 소문자 변환
     * 2. 알파벳이 아닌 문자 제거
     * 3. 문자열 뒤집기
     */
    public boolean isPalindrome(String s) {

        // 1. 대문자 -> 소문자 변환
        String upperStr = s.toLowerCase();

        // 2. 알파벳 소문자가 아닌 문자 제거
        String alphanumericStr = upperStr.replaceAll("[^a-z0-9]", "");

        // 3. 문자열 뒤집기

        // 3-1 직접 변환
        // String answer = reverseString(alphanumericStr);

        // 3-2 메서드 활용
        StringBuilder sb = new StringBuilder(alphanumericStr);
        String answer = sb.reverse().toString();

        return alphanumericStr.equals(answer);
    }

    public static String reverseString(String alphanumericStr) {
        String[] alphanumericArray = alphanumericStr.split("");
        int left = 0;
        int right = alphanumericArray.length - 1;

        while (left < right) {
            String tempStr = alphanumericArray[left];
            alphanumericArray[left] = alphanumericArray[right];
            alphanumericArray[right] = tempStr;
            left++;
            right--;
        }

        String answer = String.join("", alphanumericArray);
        return answer;
    }
}
