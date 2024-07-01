package org.kakao22;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class P1_2_Report_Result {

    /**
     * The Book solution
     *
     * 1. Create a list of reporting individuals per a reported one
     * 2. Calculate the number of sending emails for a reporting one
     */

    public int[] solution(String[] id_list, String[] report, int k) {
        // 1.
        // Removing duplication of elements
        HashSet<String> reportSet = new HashSet(Arrays.asList(report));

        Map<String, List<String>> reportedMap = new HashMap<>();
        for (String r : reportSet) {
            String[] rSplit = r.split("\\s");
            reportedMap.putIfAbsent(rSplit[1], new ArrayList<>());
            reportedMap.get(rSplit[1]).add(rSplit[0]);
        }

        // 2.
        Map<String, Integer> emailCounter = new HashMap<>();
        for (Map.Entry<String, List<String>> entry : reportedMap.entrySet()) {
            if (entry.getValue().size() >= k) {
                for (String reporting : entry.getValue()) {
                    emailCounter.put(reporting, emailCounter.getOrDefault(reporting, 0) + 1);
                }
            }
        }

        // 3.
        return Arrays.stream(id_list)
                .map(id -> emailCounter.getOrDefault(id, 0))
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
