package org.kakao22;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class P3_2_Parking_Fee_Calculation {

    /**
     * The book solution
     *
     * 1. Calculate accumulated parking for each car
     * 2. Calculate parking fees for each car
     */
    public int[] solution(int[] fees, String[] records) {
        // 1.
        Map<String, Integer> parkingLogs = new HashMap<>();
        Map<String, Integer> parkingTimes = new HashMap<>();

        for (String record : records) {
            String[] log = record.split(" ");
            String[] time = log[0].split(":");
            if (log[2].equals("IN")) {
                parkingLogs.put(log[1],
                        Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]));
            } else {
                int duration = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1])
                        - parkingLogs.get(log[1]);
                parkingTimes.put(log[1], parkingTimes.getOrDefault(log[1], 0) + duration);
                parkingLogs.remove(log[1]);
            }
        }
        for (Map.Entry<String, Integer> parkingLog : parkingLogs.entrySet()) {
            int duration = 1439 - parkingLog.getValue();
            parkingTimes.put(parkingLog.getKey(), parkingTimes.getOrDefault(parkingLog.getKey(), 0) + duration);
        }

        // 2.
        int basicTime = fees[0];
        int basicFee = fees[1];
        int addTime = fees[2];
        int addFee = fees[3];

        List<String> sortedCars = new ArrayList<>(parkingTimes.keySet());
        sortedCars.sort(Comparator.comparingInt(Integer::parseInt));

        int[] answer = new int[parkingTimes.size()];
        int idx = 0;

        for (String car : sortedCars) {
            int totalTime = parkingTimes.get(car);

            if (totalTime < basicTime) {
                answer[idx] = basicFee;
            } else {
                answer[idx] = basicFee + (int) (Math.ceil((double) (totalTime - basicTime) / addTime) * addFee);
            }
            idx++;
        }
        return answer;
    }

}
