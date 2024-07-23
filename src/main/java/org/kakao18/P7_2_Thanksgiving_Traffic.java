package org.kakao18;

import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class P7_2_Thanksgiving_Traffic {


    /**
     * The book solution using Local Date Time
     *
     * 1. Convert input logs to 'LocalDateTime' and Calculate the starting and end times
     * 2. Calculate the maximum traffic per second
     */
    public int solution(String[] lines) {

        // 1.
        List<Map.Entry<LocalDateTime, Integer>> combinedLogs = new ArrayList<>();

        for (String line : lines) {
            String[] logs = line.split(" ");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
            LocalDateTime to = LocalDateTime.parse(
                    logs[0] + " " + logs[1],
                    formatter
            );
            double processTime = Double.parseDouble(logs[2].substring(0, logs[2].length() - 1));
            Duration duration = Duration.ofMillis((long) (processTime * 1000) - 1);
            LocalDateTime from = to.minus(duration);

            combinedLogs.add(new AbstractMap.SimpleEntry(from, 1));
            combinedLogs.add(new AbstractMap.SimpleEntry(to, -1));
        }

        // 2.
        int accumulated = 0;
        int maxRequest = 1;
        combinedLogs.sort(Map.Entry.comparingByKey());

        for (int i = 0; i < combinedLogs.size(); i++) {
            Map.Entry<LocalDateTime, Integer> elem1 = combinedLogs.get(i);

            int current = accumulated;

            for (int j = i; j < combinedLogs.size(); j++) {
                Map.Entry<LocalDateTime, Integer> elem2 = combinedLogs.get(j);

                if (Duration.between(elem1.getKey(), elem2.getKey()).getSeconds() > 0.999) {
                    break;
                }
                if (elem2.getValue() > 0) {
                    current += elem2.getValue();
                }
            }
            maxRequest = Math.max(maxRequest, current);
            accumulated += elem1.getValue();
        }
        return maxRequest;

    }

}
