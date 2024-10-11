package org.kakao22;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class P3_3_Parking_Fee_Calculation {

    public int[] solution(int[] fees, String[] records) {

        Map<String, List<Integer>> fareMap = new HashMap<>();
        updateFareMap(fareMap, records);

        List<String> sortedCars = fareMap.entrySet().stream().sorted(Map.Entry.comparingByKey()).map(Map.Entry::getKey).collect(Collectors.toList());

        List<Integer> results = calcFares(sortedCars, fareMap, fees[0], fees[1], fees[2], fees[3]);

        return results.stream().mapToInt(Integer::intValue).toArray();
    }

    private int convertToSec(String time) {
        String[] timeArr = time.split(":");

        return Integer.parseInt(timeArr[0]) * 60 + Integer.parseInt(timeArr[1]);
    }

    private void updateFareMap(Map<String, List<Integer>> fareMap, String[] records) {
        for (String r : records) {
            String[] record = r.split(" ");

            fareMap.putIfAbsent(record[1], new ArrayList<>());
            fareMap.get(record[1]).add(convertToSec(record[0]));
        }
    }

    private List<Integer> calcFares(List<String> sortedCars, Map<String, List<Integer>> fareMap, int basicTime, int basicFare, int unitTime, int unitFare) {

        List<Integer> results = new ArrayList<>();

        for (String car : sortedCars) {
            List<Integer> times = fareMap.get(car);
            int time = 0;

            for (int i = 0; i < times.size(); i += 2) {
                if (i + 1 >= times.size()) {
                    time += (1439 - times.get(i));
                    continue;
                }
                time += times.get(i + 1) - times.get(i);
            }

            if (time <= basicTime) {
                results.add(basicFare);
            } else {

                results.add((int) (basicFare + Math.ceil((double) (time - basicTime) / unitTime) * unitFare));
            }
        }
        return results;
    }

}
