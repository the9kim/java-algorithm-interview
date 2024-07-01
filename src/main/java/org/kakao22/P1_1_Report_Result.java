package org.kakao22;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class P1_1_Report_Result {

    /**
     * 1. Create a list of reported individuals
     * 2. Check if report counts is greater than the standard
     * 3. Calculate the number of report result
     */

    public int[] solution(String[] id_list, String[] report, int k) {
        // 1.
        Map<String, Set<String>> reported = new LinkedHashMap<>();
        for (String id : id_list) {
            reported.put(id, new HashSet<>());
        }
        for (String r : report) {
            String[] rArr = r.split("\\s+");
            reported.get(rArr[0]).add(rArr[1]);
        }

        // 2.
        Set<String> reportedIds = new HashSet<>();
        Map<String, Integer> counter = new HashMap<>();
        for (Map.Entry<String, Set<String>> entry : reported.entrySet()) {
            for (String v : entry.getValue()) {
                counter.put(v, counter.getOrDefault(v, 0) + 1);
                if (counter.get(v) >= k) {
                    reportedIds.add(v);
                }
            }
        }

        // 3.
        List<Integer> answer = new ArrayList<>();

        for (Map.Entry<String, Set<String>> entry : reported.entrySet()) {
            int count = 0;
            for (String r : entry.getValue()) {
                if (reportedIds.contains(r)) {
                    count++;
                }
            }
            answer.add(count);
        }
        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
