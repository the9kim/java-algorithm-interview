package org.kakao22;

public class P2_3_Number_of_Prime_Numbers {

    public int solution(int n, int k) {
        String baseK = Integer.toString(n, k);
        String[] baseArr = baseK.split("0+");

        int count = 0;

        for (String base : baseArr) {
            if (isPrimeNumber(Long.parseLong(base))) {
                count++;
            }
        }

        return count;
    }

    private boolean isPrimeNumber(long num) {
        if (num <= 1 || (num > 2 && num % 2 == 0)) {
            return false;
        }
        for (int i = 3; i <= (int) Math.sqrt(num); i += 2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
