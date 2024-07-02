package org.kakao22;

public class P2_1_Number_of_Prime_Numbers {

    /**
     * Runtime Error
     *
     * Input values may exceed the range of an Integer
     */

    public int solution(int n, int k) {
        String unsigned = Integer.toUnsignedString(n, k);

        String[] nums = unsigned.split("0+");

        int count = 0;
        for (String num : nums) {
            if (checkPrimeNumber(Long.valueOf(num))) {
                count++;
            }
        }
        return count;
    }

    public boolean checkPrimeNumber(long num) {
        if (num == 0 || num == 1) {
            return false;
        }
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
