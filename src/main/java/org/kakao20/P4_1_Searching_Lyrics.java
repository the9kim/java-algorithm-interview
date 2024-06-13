package org.kakao20;

import java.util.HashMap;
import java.util.Map;

public class P4_1_Searching_Lyrics {

    /**
     * Using REGEX - Time exceeded
     *
     * 1. Transform queries into REGEX format
     * 2. Find the number of words that match the pattern
     * 3. Filter duplicated queries
     */
    public int[] solution(String[] words, String[] queries) {

        // 1.
        for (int i = 0; i < queries.length; i++) {
            queries[i] = queries[i].replace('?', '.');
        }

        // 2.
        Map<String, Integer> counter = new HashMap<>();

        int[] answer = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];

            // 3.
            if (counter.containsKey(query)) {
                answer[i] = counter.get(query);
                continue;
            }

            for (String word : words) {
                if (word.matches(query)) {
                    answer[i]++;
                }
            }
            counter.put(query, answer[i]);
        }
        return answer;
    }
}
