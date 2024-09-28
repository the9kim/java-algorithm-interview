package org.kakao21;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P3_4_Rank_Search {

    /**
     * The method that derived subsets through hard coding
     * without using bitwise operations.
     */

    static class Scores {
        List<Integer> scores = new ArrayList<>();
    }

    private static final int ALL = 0;

    private static final int CPP = 1;
    private static final int JAVA = 2;
    private static final int PYTHON = 3;

    private static final int BACK = 1;
    private static final int FRONT = 2;

    private static final int JUNIOR = 1;
    private static final int SENIOR = 2;

    private static final int CHICKEN = 1;
    private static final int PIZZA = 2;


    public int[] solution(String[] info, String[] query) {
        Scores[][][][] scores = new Scores[4][3][3][3];

        for (int a = 0; a < 4; a++) {
            for (int b = 0; b < 3; b++) {
                for (int c = 0; c < 3; c++) {
                    for (int d = 0; d < 3; d++) {
                        scores[a][b][c][d] = new Scores();
                    }
                }
            }
        }

        Map<String, Integer> indexMap = new HashMap<>();
        indexMap.put("-", ALL);
        indexMap.put("cpp", CPP);
        indexMap.put("java", JAVA);
        indexMap.put("python", PYTHON);
        indexMap.put("backend", BACK);
        indexMap.put("frontend", FRONT);
        indexMap.put("junior", JUNIOR);
        indexMap.put("senior", SENIOR);
        indexMap.put("chicken", CHICKEN);
        indexMap.put("pizza", PIZZA);

        for (String i : info) {
            String[] infoArr = i.split(" ");

            int langIdx = indexMap.get(infoArr[0]);
            int jobIdx = indexMap.get(infoArr[1]);
            int posIdx = indexMap.get(infoArr[2]);
            int foodIdx = indexMap.get(infoArr[3]);

            int score = Integer.parseInt(infoArr[4]);

            scores[langIdx][jobIdx][posIdx][foodIdx].scores.add(score);
            scores[ALL][jobIdx][posIdx][foodIdx].scores.add(score);
            scores[langIdx][ALL][posIdx][foodIdx].scores.add(score);
            scores[langIdx][jobIdx][ALL][foodIdx].scores.add(score);
            scores[langIdx][jobIdx][posIdx][ALL].scores.add(score);
            scores[ALL][ALL][posIdx][foodIdx].scores.add(score);
            scores[ALL][jobIdx][ALL][foodIdx].scores.add(score);
            scores[ALL][jobIdx][posIdx][ALL].scores.add(score);
            scores[langIdx][ALL][ALL][foodIdx].scores.add(score);
            scores[langIdx][ALL][posIdx][ALL].scores.add(score);
            scores[langIdx][jobIdx][ALL][ALL].scores.add(score);
            scores[ALL][ALL][ALL][foodIdx].scores.add(score);
            scores[ALL][ALL][posIdx][ALL].scores.add(score);
            scores[ALL][jobIdx][ALL][ALL].scores.add(score);
            scores[langIdx][ALL][ALL][ALL].scores.add(score);
            scores[ALL][ALL][ALL][ALL].scores.add(score);
        }

        for (int a = 0; a < 4; a++) {
            for (int b = 0; b < 3; b++) {
                for (int c = 0; c < 3; c++) {
                    for (int d = 0; d < 3; d++) {
                        if (!scores[a][b][c][d].scores.isEmpty()) {
                            Collections.sort(scores[a][b][c][d].scores);
                        }
                    }
                }
            }
        }

        List<Integer> results = new ArrayList<>();

        for (String q : query) {
            q = q.replaceAll("and", "");
            String[] qArr = q.split("\\s+");

            int langIdx = indexMap.get(qArr[0]);
            int jobIdx = indexMap.get(qArr[1]);
            int posIdx = indexMap.get(qArr[2]);
            int foodIdx = indexMap.get(qArr[3]);

            int targetScore = Integer.parseInt(qArr[4]);

            List<Integer> scoreList = scores[langIdx][jobIdx][posIdx][foodIdx].scores;

            int pos = Collections.binarySearch(scoreList, targetScore);

            if (pos < 0) {
                pos = -(pos + 1);
            } else {
                for (int i = pos - 1; i >= 0; i--) {
                    if (scoreList.get(i) == targetScore) {
                        pos = i;
                    } else {
                        break;
                    }
                }
            }

            results.add(scoreList.size() - pos);

        }

        return results.stream().mapToInt(Integer::intValue).toArray();

    }
}
