package org.kakao21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

public class P3_2_Rank_Search {
    /**
     * Time-Exceeded & Runtime error
     *
     */
    public int[] solution(String[] info, String[] query) {
        // 1.
        Map<String, List<Integer>> scoreMap = new HashMap<>();

        for (int id = 0; id < info.length; id++) {
            String[] infoArr = info[id].split("\\s");
            String[] key = Arrays.copyOfRange(infoArr, 0, 4);
            int score = Integer.valueOf(infoArr[4]);

            scoreMap.putIfAbsent(String.join(" ", key), new ArrayList<>());
            scoreMap.get(String.join(" ", key)).add(score);
        }

        // 2.
        int[] answer = new int[query.length];

        for (int i = 0; i < query.length; i++) {
            String[] qArr = query[i].replaceAll("and", "").split("\\s+");
            String q = parseQuery(Arrays.copyOfRange(qArr, 0, 4));
            int score = Integer.valueOf(qArr[4]);

            int count = 0;

            if (q.contains(".+")) {
                for (Map.Entry<String, List<Integer>> entry : scoreMap.entrySet()) {
                    if (entry.getKey().matches(q)) {
                        count += entry.getValue().stream()
                                .filter(s -> s >= score)
                                .count();
                    }
                }
            } else {
                count += scoreMap.get(q).stream()
                        .filter(s -> s >= score)
                        .count();
            }
            answer[i] = count;
        }

        return answer;
    }

    public String parseQuery(String[] query) {
        StringJoiner sj = new StringJoiner(" ");

        for (String q : query) {
            if (q.equals("-")) {
                sj.add(".+");
            } else {
                sj.add(q);
            }
        }
        return sj.toString();
    }
}
