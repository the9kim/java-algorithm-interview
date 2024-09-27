package org.kakao21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class P2_1_Menu_Renewal {

    /**
     * 1. Calculate the combination of a string based on the length of it
     * 2. Calculate the most frequent combination based on the length of it
     */
    public String[] solution(String[] orders, int[] course) {
        List<String> results = new ArrayList<>();

        for (int menuSize : course) {
            Map<String, Integer> counter = new HashMap<>();

            // 1
            updateMenuCounter(orders, menuSize, counter);

            // 2
            updateMaxMenus(counter, results);
        }

        Collections.sort(results);

        return results.toArray(new String[0]);
    }

    private void updateMaxMenus(Map<String, Integer> counter, List<String> results) {
        int maxCount = counter.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getValue)
                .orElse(0);

        List<String> menus = counter.entrySet().stream()
                .filter(e -> e.getValue() > 1 && e.getValue() == maxCount)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        results.addAll(menus);
    }

    private void updateMenuCounter(String[] orders, int size, Map<String, Integer> counter) {
        for (String order : orders) {

            char[] sorted = order.toCharArray();
            Arrays.sort(sorted);

            calcCombinations(counter, new String(sorted), size, new StringBuilder(), 0);
        }
    }

    private void calcCombinations(Map<String, Integer> counter, String order, int size, StringBuilder elems, int index) {

        if (elems.length() == size) {
            counter.put(elems.toString(), counter.getOrDefault(elems.toString(), 0) + 1);
            return;
        }

        for (int i = index; i < order.length(); i++) {
            elems.append(order.charAt(i));
            calcCombinations(counter, order, size, elems, i + 1);
            elems.deleteCharAt(elems.length() - 1);
        }
    }

}
