package org.kakao21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

public class P3_3_Rank_Search {
    /**
     * 1. Calculate the number of possible cases of query and make them lists
     * 2. Convert each information to 16 cases and insert scores to the list based on each case
     * 3. Search the number of people that scores higher than the condition with queries using Binary search
     */

    List<List<Integer>> scores = new ArrayList<>();
    Map<String, Integer> wordMap = new HashMap<>();

    public int[] solution(String[] info, String[] query) {
        // 1.
        wordMap.put("-", 0);
        wordMap.put("cpp", 1);
        wordMap.put("java", 2);
        wordMap.put("python", 3);
        wordMap.put("backend", 1);
        wordMap.put("frontend", 2);
        wordMap.put("junior", 1);
        wordMap.put("senior", 2);
        wordMap.put("chicken", 1);
        wordMap.put("pizza", 2);

        for (int i = 0; i < 4 * 3 * 3 * 3; i++) {
            scores.add(new ArrayList<>());
        }

        // 2.
        for (String s : info) {
            String[] words = s.split(" ");
            int[] wordArr = {
                    wordMap.get(words[0]) * 3 * 3 * 3,
                    wordMap.get(words[1]) * 3 * 3,
                    wordMap.get(words[2]) * 3,
                    wordMap.get(words[3])};

            int score = Integer.parseInt(words[4]);

            for (int i = 0; i < (1 << 4); ++i) {
                int index = 0;
                for (int j = 0; j < 4; ++j) {
                    if ((i & (1 << j)) != 0) {
                        index += wordArr[j];
                    }
                }
                scores.get(index).add(score);
            }
        }

        // 3.
        for (int i = 0; i < 4 * 3 * 3 * 3; i++) {
            Collections.sort(scores.get(i));
        }

        int[] answer = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            String q = query[i];
            String[] qArr = q.split(" ");
            int index = wordMap.get(qArr[0]) * 3 * 3 * 3 +
                    wordMap.get(qArr[2]) * 3 * 3 +
                    wordMap.get(qArr[4]) * 3 +
                    wordMap.get(qArr[6]);
            int score = Integer.parseInt(qArr[7]);

            int ret = Collections.binarySearch(scores.get(index), score);

            if (ret < 0) {
                ret = -(ret + 1);
            } else {
                for (int j = ret - 1; j >= 0; j--) {
                    if (scores.get(index).get(j) == score) {
                        ret = j;
                    } else {
                        break;
                    }
                }
            }
            answer[i] = scores.get(index).size() - ret;
        }
        return answer;
    }
}
