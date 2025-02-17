package org.kakao19;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P3_5_Candidate_Key {

    public int solution(String[][] relation) {
        int colCount = relation[0].length; // Number of columns
        List<Integer> candidateKeys = new ArrayList<>();

        // Iterate through all possible subsets of columns
        for (int subset = 1; subset < (1 << colCount); subset++) {
            // Check for minimality
            if (!isMinimal(candidateKeys, subset)) {
                continue;
            }

            // Check for uniqueness
            if (isUnique(relation, subset)) {
                candidateKeys.add(subset);
            }
        }

        return candidateKeys.size();
    }

    private boolean isMinimal(List<Integer> candidateKeys, int subset) {
        for (Integer key : candidateKeys) {
            if ((subset & key) == key) { // Check if current subset contains an existing key
                return false;
            }
        }
        return true;
    }

    private boolean isUnique(String[][] relation, int subset) {
        Set<String> uniqueCombinations = new HashSet<>();

        for (String[] row : relation) {
            StringBuilder sb = new StringBuilder();
            for (int col = 0; col < relation[0].length; col++) {
                if ((subset & (1 << col)) != 0) { // Check if column `col` is part of the subset
                    sb.append(row[col]).append("#"); // Use a unique delimiter
                }
            }

            if (!uniqueCombinations.add(sb.toString())) { // If the combination already exists
                return false;
            }
        }

        return true;
    }

}
