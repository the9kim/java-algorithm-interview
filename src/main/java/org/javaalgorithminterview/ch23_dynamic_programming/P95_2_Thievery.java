package org.javaalgorithminterview.ch23_dynamic_programming;

import java.util.Arrays;

public class P95_2_Thievery {
    public int solution(int[] money) {
        if (money.length == 1) {
            return money[0];
        }

        int[][] answer = new int[2][money.length];

        answer[0][0] = 0;
        answer[0][1] = 0;
        answer[1][0] = 0;
        answer[1][1] = money[1];

        for (int i = 2; i < money.length; i++) {
            answer[0][i] = Math.max(answer[0][i - 1], answer[0][i - 2] + money[i]);
            answer[1][i] = Math.max(answer[1][i - 1], answer[1][i - 2] + money[i]);
        }
        return Math.max(answer[0][money.length - 2] + money[0], answer[1][money.length - 1]);
    }
}
