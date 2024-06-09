package org.kakao18;

import java.util.HashMap;
import java.util.Map;

public class P5_1_News_Clustering {

    /**
     * 1. Cluster input strings
     * 2. Calculate the intersection and union of the two inputs
     * 3. Calculate the Jaccard similarity
     */
    public int solution(String str1, String str2) {
        //1
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        Map<String, Integer> counter1 = getCounter(str1);
        Map<String, Integer> counter2 = getCounter(str2);


        //2.
        Map<String, Integer> intersection = new HashMap<>();
        for (String key : counter1.keySet()) {
            if (counter2.containsKey(key)) {
                intersection.put(key, Math.min(counter1.get(key), counter2.get(key)));
            }
        }

        Map<String, Integer> union = new HashMap<>(counter1);
        for (String key : counter2.keySet()) {
            if (union.containsKey(key)) {
                union.put(key, Math.max(counter1.get(key), counter2.get(key)));
            } else {
                union.put(key, counter2.get(key));
            }
        }

        // 3.
        int intersectionSum = intersection.values().stream()
                .mapToInt(Integer::intValue)
                .sum();
        int unionSum = union.values().stream()
                .mapToInt(Integer::intValue)
                .sum();

        if (unionSum == 0) {
            return 65536;
        }

        return (int) Math.floor((intersectionSum / (double) unionSum) * 65536);
    }

    private Map<String, Integer> getCounter(String str) {

        Map<String, Integer> counter = new HashMap<>();

        if (str.length() == 1) {
            counter.put(str, 1);
            return counter;
        }

        for (int i = 0; i < str.length() - 1; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(str.charAt(i));
            sb.append(str.charAt(i + 1));

            String s = sb.toString();
            String pattern = "[a-z]{2}";

            if (!s.matches(pattern)) {
                continue;
            }
            counter.put(s, counter.getOrDefault(s, 0) + 1);
        }
        return counter;
    }
}
