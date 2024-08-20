package org.kakao18;

import java.util.Arrays;

public class P7_1_Thanksgiving_Traffic {

    static final int MAX = 24 * 60 * 60 * 1000;
    int[] traffic = new int[MAX];

    /**
     * 1. Calculate accumulated request counts using array
     * 2. Calculate maximum processing capacity per second
     */
    public int solution(String[] lines) {
        // 1.
        for (String line : lines) {
            int from = convertToStart(line);
            int to = convertToEnd(line);

            for (int i = from; i <= to + 999; i++) {
                if (i >= 0 && i < MAX) {
                    traffic[i] += 1;
                }
            }
        }

        // 2.
        return Arrays.stream(traffic).max().getAsInt();
    }

    public int convertToStart(String line) {
        int end = convertToEnd(line);
        int ps = (int) (Double.parseDouble(line.substring(24, line.length() - 1)) * 1000);

        return end - ps + 1;
    }

    public int convertToEnd(String line) {
        int h = Integer.valueOf(line.substring(11, 13));
        int m = Integer.valueOf(line.substring(14, 16));
        int s = Integer.valueOf(line.substring(17, 19));
        int ms = Integer.valueOf(line.substring(20, 23));

        return h * 60 * 60 * 1000 + m * 60 * 1000 + s * 1000 + ms;
    }

}
