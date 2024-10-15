package org.kakao22;

import java.util.ArrayList;
import java.util.List;

public class P4_2_Archery_Tournament {

    /**
     * Method to generate combinations with repetition
     */

    public int[] solution(int n, int[] info) {

        List<List<Integer>> combinations = new ArrayList<>();
        getCombinationWithRepetition(combinations, n, new ArrayList<>(), 0);

        return retrieveOptimalCombination(combinations, info);

    }

    public void getCombinationWithRepetition(List<List<Integer>> combinations, int n, List<Integer> elems, int idx) {
        if (elems.size() == n) {
            combinations.add(new ArrayList<>(elems));
            return;
        }

        for (int i = idx; i <= 10; i++) {
            elems.add(i);
            getCombinationWithRepetition(combinations, n, elems, i);
            elems.remove(elems.size() - 1);
        }
    }

    private int[] retrieveOptimalCombination(List<List<Integer>> combinations, int[] info) {
        int maxDiff = 0;
        int[] maxScores = new int[11];

        for (List<Integer> c : combinations) {
            int[] scores = new int[11];

            for (int num : c) {
                scores[10 - num]++;
            }
            int diff = 0;

            for (int i = 0; i <= 10; i++) {
                if (info[i] == 0 && scores[i] == 0) {
                    continue;
                }

                if (info[i] < scores[i]) {
                    diff += (10 - i);
                } else if (info[i] >= scores[i]) {
                    diff -= (10 - i);
                }
            }

            if (diff > maxDiff) {
                maxDiff = diff;
                maxScores = scores;
            } else if (diff == maxDiff) {
                for (int j = 10; j >= 0; j--) {
                    if (maxScores[j] == scores[j]) {
                        continue;
                    }
                    if (maxScores[j] < scores[j]) {
                        maxScores = scores;
                    }
                    break;
                }
            }
        }

        return maxDiff != 0 ? maxScores : new int[]{-1};
    }

}
