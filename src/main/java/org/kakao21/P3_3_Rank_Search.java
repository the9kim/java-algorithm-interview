package org.kakao21;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P3_3_Rank_Search {
    /**
     * 1. Calculate the number of possible cases of query and make them lists
     * 2. Convert each information to 16 cases and insert scores to the list based on each case
     * 3. Search the number of people that scores higher than the condition with queries using Binary search
     */

    static final int SIZE = 4 * 3 * 3 * 3;
    List<List<Integer>> scores = new ArrayList<>();
    Map<String, Integer> indexMap = new HashMap<>();

    public int[] solution(String[] info, String[] query) {
        setDataStructure();

        updateInfo(info);

        sortScores(scores);

        List<Integer> results = searchRank(query);

        return results.stream().mapToInt(Integer::intValue).toArray();
    }

    private void setDataStructure() {
        for (int i = 0; i < SIZE; i++) {
            scores.add(new ArrayList<>());
        }
        indexMap.put("-", 0);
        indexMap.put("cpp", 1);
        indexMap.put("java", 2);
        indexMap.put("python", 3);
        indexMap.put("backend", 1);
        indexMap.put("frontend", 2);
        indexMap.put("junior", 1);
        indexMap.put("senior", 2);
        indexMap.put("chicken", 1);
        indexMap.put("pizza", 2);
    }

    private void updateInfo(String[] info) {
        for (String data : info) {
            String[] splitInfo = data.split(" ");
            int[] indices = new int[]{
                    indexMap.get(splitInfo[0]) * 3 * 3 * 3,
                    indexMap.get(splitInfo[1]) * 3 * 3,
                    indexMap.get(splitInfo[2]) * 3,
                    indexMap.get(splitInfo[3])
            };
            int score = Integer.parseInt(splitInfo[4]);

            for (int i = 0; i < 1 << 4; i++) {
                int index = 0;
                for (int j = 0; j < 4; j++) {
                    if ((i & (1 << j)) != 0) {
                        index += indices[j];
                    }
                }
                scores.get(index).add(score);
            }
        }
    }

    private void sortScores(List<List<Integer>> scores) {
        for (List<Integer> score : scores) {
            Collections.sort(score);
        }
    }

    private List<Integer> searchRank(String[] query) {
        List<Integer> results = new ArrayList<>();

        for (String q : query) {
            String[] qSplit = q.split(" ");
            int index = indexMap.get(qSplit[0]) * 3 * 3 * 3
                    + indexMap.get(qSplit[2]) * 3 * 3
                    + indexMap.get(qSplit[4]) * 3
                    + indexMap.get(qSplit[6]);
            int targetScore = Integer.parseInt(qSplit[7]);

            int position = Collections.binarySearch(scores.get(index), targetScore);

            if (position < 0) {
                position = -(position + 1);
            } else {
                for (int i = position - 1; i >= 0; i--) {
                    if (scores.get(index).get(i) == targetScore) {
                        position = i;
                    } else {
                        break;
                    }
                }
            }

            results.add(scores.get(index).size() - position);
        }

        return results;
    }
}
