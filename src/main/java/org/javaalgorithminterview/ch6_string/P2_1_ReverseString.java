package org.javaalgorithminterview.ch6_string;

public class P2_1_ReverseString {

    /**
     * 투포인터
     * 1. 왼쪽 포인터 값과 오른쪽 포인터 값을 바꾼다.
     * 2. 포인터를 이동(왼쪽 + 1, 오른쪽 -1)한다.
     */
    public static void reverseString(char[] s) {

        int left = 0;
        int right = s.length - 1;

        while (left < right) {
            char tempChar = s[left];
            s[left] = s[right];
            s[right] = tempChar;

            left++;
            right--;
        }
    }
}
