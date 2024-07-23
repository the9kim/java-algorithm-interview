package org.kakao18;

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
        int maxTraffic = 0;
        for (int t : traffic) {
            if (t > maxTraffic) {
                maxTraffic = t;
            }
        }
        return maxTraffic;
    }

    public int convertToStart(String line) {
        int end = convertToEnd(line);

        String psTemp = line.substring(24, line.length() - 1);
        String[] psArr = psTemp.split("\\.");
        int ps;
        if (psArr.length == 1) {
            ps = Integer.valueOf(psArr[0]) * 1000;
        } else {
            ps = Integer.valueOf(psArr[0]) * 1000 + Integer.valueOf(psArr[1]);
        }

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
