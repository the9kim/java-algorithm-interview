package org.kakao21;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class P2_3_Menu_Renewal {
    Map<Integer, Map<String, Integer>> setMenu = new HashMap<>();
    Map<Integer, Integer> maxSetMenuCount = new HashMap<>();

    public String[] solution(String[] orders, int[] course) {

        for (int size : course) {
            setMenu.put(size, new HashMap<>());
            maxSetMenuCount.put(size, 0);

            for (String order : orders) {
                char[] orderArr = order.toCharArray();
                Arrays.sort(orderArr);
                extractSubset(orderArr, size, new StringBuilder(), 0);
            }
        }

        List<String> results = new ArrayList<>();

        for (int size : course) {
            int maxMenuCount = maxSetMenuCount.get(size);

            List<String> freqs = setMenu.get(size).entrySet().stream()
                    .filter(e -> e.getValue() >= 2 && e.getValue() == maxMenuCount)
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toList());

            results.addAll(freqs);
        }

        Collections.sort(results);

        return results.toArray(new String[0]);


    }

    public void extractSubset(char[] order, int size, StringBuilder sb, int idx) {

        if (sb.length() == size) {
            Map<String, Integer> menuCounter = setMenu.get(size);
            String menuCombination = sb.toString();
            menuCounter.put(menuCombination, menuCounter.getOrDefault(menuCombination, 0) + 1);

            if (maxSetMenuCount.get(size) < menuCounter.get(menuCombination)) {
                maxSetMenuCount.put(size, menuCounter.get(menuCombination));
            }

            return;
        }

        for (int i = idx; i < order.length; i++) {
            sb.append(order[i]);
            extractSubset(order, size, sb, i + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
