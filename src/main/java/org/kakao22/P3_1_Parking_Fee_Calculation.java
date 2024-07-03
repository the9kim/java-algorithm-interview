package org.kakao22;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class P3_1_Parking_Fee_Calculation {

    /**
     * 1. Calculate accumulated parking for each car
     * 2. Calculate parking fees for each car
     */
    public int[] solution(int[] fees, String[] records) {
        // 1.
        Map<String, List<Integer>> parkingRecords = new HashMap<>();

        for (String s : records) {
            String[] split = s.split("\\s");
            int time = convertToMin(split[0]);
            String number = split[1];
            parkingRecords.putIfAbsent(number, new ArrayList<>());
            parkingRecords.get(number).add(time);
        }

        Map<String, Integer> parkingTime = new HashMap<>();
        for (Map.Entry<String, List<Integer>> entry : parkingRecords.entrySet()) {
            List<Integer> record = entry.getValue();
            int time = 0;
            for (int i = 0; i < record.size() - 1; i += 2) {
                time += record.get(i + 1) - record.get(i);
            }
            if (record.size() % 2 != 0) {
                time += 1439 - record.get(record.size() - 1);
            }
            parkingTime.put(entry.getKey(), time);
        }

        // 2.
        int basicTime = fees[0];
        int basicFee = fees[1];
        int addTime = fees[2];
        int addFee = fees[3];

        Queue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(Map.Entry.comparingByKey());

        for (Map.Entry<String, Integer> entry : parkingTime.entrySet()) {
            Integer totalTime = entry.getValue();

            int totalFee = totalTime < basicTime ? basicFee
                    : (int) (basicFee + Math.ceil((double) (totalTime - basicTime) / addTime) * addFee);
            pq.add(new AbstractMap.SimpleEntry<>(entry.getKey(), totalFee));
        }

        int[] answer = new int[pq.size()];
        int index = 0;
        while (!pq.isEmpty()) {
            answer[index] = pq.poll().getValue();
            index++;
        }
        return answer;
    }

    public int convertToMin(String time) {
        String[] split = time.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }

}
