package org.kakao21;

import java.util.stream.IntStream;

public class P5_2_Advertise_Insertion {

    public String solution(String play_time, String adv_time, String[] logs) {
        int playSec = convertTimeToSec(play_time);
        int advSec = convertTimeToSec(adv_time);
        int[] cumulativeSum = new int[playSec + 1];

        calcCumulativeSum(cumulativeSum, logs);

        int maxIdx = findOptimalTime(advSec, cumulativeSum, playSec);

        return convertSecToTime(maxIdx);

    }

    private void calcCumulativeSum(int[] cumulativeSum, String[] logs) {
        for (String log : logs) {
            int from = convertTimeToSec(log.split("-")[0]);
            int to = convertTimeToSec(log.split("-")[1]);

            cumulativeSum[from] += 1;
            cumulativeSum[to] -= 1;
        }

        for (int i = 1; i < cumulativeSum.length; i++) {
            cumulativeSum[i] += cumulativeSum[i - 1];
        }
    }

    private  int findOptimalTime(int advSec, int[] cumulativeSum, int playSec) {
        long sum = IntStream.range(0, advSec).map(i -> cumulativeSum[i]).sum();
        int maxIdx = 0;
        long maxSum = sum;


        for (int j = advSec; j < playSec; j++) {
            sum = sum + cumulativeSum[j] - cumulativeSum[j - advSec];
            if (maxSum < sum) {
                maxSum = sum;
                maxIdx = j - advSec + 1;
            }
        }
        return maxIdx;
    }

    private int convertTimeToSec(String time) {
        String[] timeArr = time.split(":");

        return Integer.parseInt(timeArr[0]) * 60 * 60
                + Integer.parseInt(timeArr[1]) * 60
                + Integer.parseInt(timeArr[2]);
    }

    private String convertSecToTime(int sec) {
        return String.format("%02d:%02d:%02d", sec / 3600, sec % 3600 / 60, sec % 60);
    }

}
