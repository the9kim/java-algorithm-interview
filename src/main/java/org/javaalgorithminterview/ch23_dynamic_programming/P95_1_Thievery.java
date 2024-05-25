package org.javaalgorithminterview.ch23_dynamic_programming;

import java.util.Arrays;

public class P95_1_Thievery {
    public int solution(int[] money) {
        return Math.max(
                calculateMax(Arrays.copyOfRange(money, 0, money.length - 1)),
                calculateMax(Arrays.copyOfRange(money, 1, money.length))
        );
    }

    private int calculateMax(int[] money) {
        money[1] = Math.max(money[0], money[1]);

        for (int i = 2; i < money.length; i++) {
            money[i] = Math.max(money[i - 1], money[i - 2] + money[i]);
        }
        return money[money.length - 1];
    }
}
