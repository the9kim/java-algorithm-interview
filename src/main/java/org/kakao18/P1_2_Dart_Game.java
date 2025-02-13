package org.kakao18;

import java.util.ArrayDeque;
import java.util.Deque;

public class P1_2_Dart_Game {
    public int solution(String dartResult) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < dartResult.length(); i++) {
            char c = dartResult.charAt(i);

            if (Character.isDigit(c)) {
                int digit = Character.getNumericValue(c);
                if (i + 1 < dartResult.length() && Character.isDigit(dartResult.charAt(i + 1))) {
                    digit = digit * 10 + Character.getNumericValue(dartResult.charAt(++i));
                }
                stack.push(digit);
            } else if (c == 'D') {
                stack.push((int) Math.pow(stack.pop(), 2));
            } else if (c == 'T') {
                stack.push((int) Math.pow(stack.pop(), 3));
            } else if (c == '*') {
                int curr = stack.pop() * 2;
                if (!stack.isEmpty()) {
                    stack.push(stack.pop() * 2);
                }
                stack.push(curr);
            } else if (c == '#') {
                stack.push(-stack.pop());
            }
        }

        int totalScore = 0;

        while (!stack.isEmpty()) {
            totalScore += stack.pop();
        }

        return totalScore;
    }

}
