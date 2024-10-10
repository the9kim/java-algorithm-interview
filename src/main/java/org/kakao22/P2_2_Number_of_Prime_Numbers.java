package org.kakao22;

import java.util.ArrayDeque;
import java.util.Deque;

public class P2_2_Number_of_Prime_Numbers {

    /**
     * Implement logic to convert an input number to an unsigned long number on your own
     */

    public int solution(int n, int k) {

        Deque<Integer> stack = new ArrayDeque<>();
        int remainder;
        while (n != 0) {
            remainder = n % k;
            n /= k;
            stack.push(remainder);
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        int count = 0;
        for (String s : sb.toString().split("0+")) {
            if (isPrimeNumber(Long.parseLong(s))) {
                count++;
            }
        }
        return count;
    }

    public boolean isPrimeNumber(long num) {
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
