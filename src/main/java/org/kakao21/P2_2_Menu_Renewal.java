package org.kakao21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P2_2_Menu_Renewal extends P2_1_Menu_Renewal{

    /**
     * 0. Set up data structures
     * 1. Calculate the combination of a string based on the length of it
     * 2. Calculate the most frequent combination based on the length of it
     * 3. Sort the result and return it
     */

    List<Map<String, Integer>> counter;
    int[] maxCount;

    public String[] solution(String[] orders, int[] course) {
        // 0.
        counter = new ArrayList<>();
        maxCount = new int[10];
        for (int i = 1; i <= 10; i++) {
            counter.add(new HashMap<>());
        }

        // 1.
        for (int size : course) {
            for (String order : orders) {
                if (order.length() >= size) {
                    char[] sorted = order.toCharArray();
                    Arrays.sort(sorted);
                    getCombination(sorted, size, new StringBuilder(), 0);
                }
            }
        }

        // 2.
        List<String> answer = new ArrayList<>();
        for (int size : course) {
            Map<String, Integer> countMap = counter.get(size - 2);
;
            for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
                if (entry.getValue() >= 2
                        && entry.getValue() == maxCount[size - 2]) {
                    answer.add(entry.getKey());
                }
            }
        }

        // 3.
        Collections.sort(answer);
        return answer.toArray(new String[0]);
    }

    public void getCombination(char[] order, int size, StringBuilder sb, int index) {
        if (sb.length() == size) {
            Map<String, Integer> counterMap = counter.get(size - 2);
            counterMap.put(sb.toString(), counterMap.getOrDefault(sb.toString(), 0) + 1);
            maxCount[size - 2] = Math.max(maxCount[size - 2], counterMap.get(sb.toString()));
            return;
        }

        for (int i = index; i < order.length; i++) {
            char c = order[i];
            sb.append(c);
            getCombination(order, size, sb, i + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
