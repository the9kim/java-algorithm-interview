package org.kakao21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P2_1_Menu_Renewal {

    /**
     * 1. Calculate the combination of a string based on the length of it
     * 2. Calculate the most frequent combination based on the length of it
     */

    Map<String, Integer> counter = new HashMap<>();

    public String[] solution(String[] orders, int[] course) {

        // 1.
        for (int size : course) {
            for (String order : orders) {
                if (order.length() >= size) {
                    char[] sorted = order.toCharArray();
                    Arrays.sort(sorted);
                    getCombination(new String(sorted), size, new StringBuilder(), 0);
                }
            }
        }

        // 2.
        List<String> answer = new ArrayList<>();
        for (int size : course) {
            Integer maxCount = counter.entrySet().stream()
                    .filter(e -> e.getKey().length() == size)
                    .max(Map.Entry.comparingByValue())
                    .map(Map.Entry::getValue)
                    .orElse(0);


            for (Map.Entry<String, Integer> entry : counter.entrySet()) {
                if (entry.getKey().length() == size
                        && entry.getValue() >= 2
                        && entry.getValue() == maxCount) {
                    answer.add(entry.getKey());
                }
            }
        }

        Collections.sort(answer);
        return answer.toArray(new String[0]);
    }

    public void getCombination(String order, int size, StringBuilder sb, int index) {
        if (sb.length() == size) {
            counter.put(sb.toString(), counter.getOrDefault(sb.toString(), 0) + 1);
            return;
        }

        for (int i = index; i < order.length(); i++) {
            char c = order.charAt(i);
            sb.append(c);
            getCombination(order, size, sb, i + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
