package org.kakao21;

public class P5_1_Advertise_Insertion {

    /**
     * 1. Calculate the cumulative sum of viewing time using an array
     * 2. Calculate the max sum in a moving window using sliding window
     */
    public String solution(String play_time, String adv_time, String[] logs) {
        int playTime = convert(play_time);
        int advTime = convert(adv_time);

        // 1.
        int[] secPlayTime = new int[100 * 60 * 60];

        for (String log : logs) {
            int start = convert(log.substring(0, 8));
            int end = convert(log.substring(9));

            for (int i = start; i < end; i++) {
                secPlayTime[i] += 1;
            }
        }

        // 2.
        long sum = 0;
        for (int i = 0; i < advTime; i++) {
            sum += secPlayTime[i];
        }

        long maxSum = sum;
        int idx = 0;

        for (int j = advTime; j < playTime; j++) {
            sum = sum + secPlayTime[j] - secPlayTime[j - advTime];
            if (maxSum < sum) {
                maxSum = sum;
                idx = j - advTime + 1;
            }
        }

        return String.format("%02d:%02d:%02d",
                idx / 3600,
                idx / 60 % 60,
                idx % 60
        );
    }

    public int convert(String time) {
        String[] timeArr = time.split(":");
        return Integer.parseInt(timeArr[0]) * 3600
                + Integer.parseInt(timeArr[1]) * 60
                + Integer.parseInt(timeArr[2]);
    }
}
