package org.kakao18;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class P1_1_Dart_Game {
    public int solution(String dartResult) {
        Deque<Double> score = new ArrayDeque<>();

        int idx = 0;

        double point = 0;

        while (idx < dartResult.length()) {
            char cur = dartResult.charAt(idx);
            if (Character.isDigit(cur)) {
                if (idx != 0) {
                    score.push(point);
                }
                if (cur == '1' && dartResult.charAt(idx + 1) == '0') {
                    point = 10;
                    idx++;
                } else {
                    point = Character.getNumericValue(cur);
                }
            } else if (cur == 'S') {
                point = Math.pow(point, 1);
            } else if (cur == 'D') {
                point = Math.pow(point, 2);
            } else if (cur == 'T') {
                point = Math.pow(point, 3);
            } else if (cur == '*') {
                if (score.peek() != null) {
                    score.push(score.poll() * 2);
                }
                point *= 2;
            } else if (cur == '#') {
                point = -point;
            }
            idx++;
        }
        score.push(point);

        return score.stream().mapToInt(Double::intValue).sum();
    }
}
