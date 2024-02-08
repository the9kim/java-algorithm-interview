package org.javaalgorithminterview.ch6_string;

public class P1_2_Valid_Palindrome2 {

    public static void main(String[] arg) {
        String s = "abcca";
    }

    /**
     * 문자 단위 비교 - 투포인터
     * 1-1 양쪽 포인터의 값이 같을 경우 -> 각각의 포인터 가운데로 한칸씩 이동
     * 1-2 양쪽 포인터 값이 다를 경우
     *  1-2-1 왼쪽+1과 포인터와 오른쪽 포인터 값이 같을 경우
     *      - new 포인터 사이 값의 팰린드롬 검증
     *      - true 반환
     *  1-2-1 왼쪽과 오른쪽-1 포인터 값이 같을 경우 -> new 포인터 사이 값의 팰린드롬 검증
     *      - new 포인터 사이 값의 팰린드롬 검증
     *      - true 반환
     *  1-2-3 false 반환
     *
     *  기존 문제점 개선 방식: 문자 단위에서 팰린드롬이 성립하지 않을 경우
     *  (왼포인터 + 1 == 오른포인터) 상황에서 부분 문자열의 팰린드롬 검증과
     *  (왼포인터 == 오른포인터-1) 상황에서 부분 문자열의 팰린드롬 검증을 순차적으로 진행하여
     *  특수 케이스(하나의 문자를 제거하고 팰린드롬 여부 판별) 검증 진행
     */
    public boolean validPalindrome(String s) {

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                if (isPalindrome(s.substring(left + 1, right + 1))) {
                    return true;
                } else if (isPalindrome(s.substring(left, right))) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }


    /**
     * 문제점 : (왼포인터 + 1 == 오른포인터)와 (왼포인터 == 오른포인터-1)이 모두 성립하는 경우 순서 구분이 안 됨
     */
    public boolean WrongValidPalindrome2(String s) {
        int counter = 0;

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else if (s.charAt(left + 1) == s.charAt(right) && counter == 0) {
                left++;
                counter++;
            } else if (s.charAt(left) == s.charAt(right - 1) && counter == 0) {
                right--;
                counter++;
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * 문자 단위 비교
     * 1. 좌우 문자가 같을 경우 포인터를 중앙으로 한칸씩 이동한다.
     * 2. 문자가 다르고 카운터가 0일 경우
     * - 왼쪽 포인터를 한칸 옮겼을 때 팰린드롬이 성립하면 포인터를 옮긴다.
     * - 오른쪽 포인터를 한칸 옮겼을 때 팰린드롬이 성립하면 포인터를 옮긴다.
     *
     * 문제점 : 재귀 함수를 단 한번만 호출해야 하는 조건을 충족하지 못함
     */

    public boolean wrongValidPalindrome1(String s) {
        int counter = 0;

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else if (validPalindrome(s.substring(left + 1, right + 1))) {
                return true;
            } else if (validPalindrome(s.substring(left, right))) {
                return false;
            } else {
                return false;
            }
        }
        return true;
    }
}
