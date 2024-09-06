package org.kakao19;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P3_4_Candidate_Key {

    public int solution(String[][] relation) {
        int rowSize = relation.length;
        int colSize = relation[0].length;


        List<Integer> uniqueMinTuples = new ArrayList<>();

        for (int sub = 1; sub < (1 << colSize); sub++) {

            Set<String> subsetTuples = generateSubsetTuples(relation, rowSize, colSize, sub);

            if (isUnique(subsetTuples, rowSize) && isMinimal(sub, uniqueMinTuples)) {
                uniqueMinTuples.add(sub);
            }
        }
        return uniqueMinTuples.size();
    }

    private Set<String> generateSubsetTuples(String[][] relation, int row_size, int col_size, int sub) {
        Set<String> tuples = new HashSet<>();

        for (int row = 0; row < row_size; row++) {

            StringBuilder tuple = new StringBuilder();

            for (int digit = 0; digit < col_size; digit++) {
                if ((sub & (1 << digit)) != 0) {
                    tuple.append(relation[row][digit]).append(",");
                }
            }
            tuples.add(tuple.toString());
        }
        return tuples;
    }

    private boolean isUnique(Set<String> subsetTuples, int row_size) {
        return subsetTuples.size() == row_size;
    }

    private boolean isMinimal(int subset, List<Integer> uniqueMinTuples) {
        for (Integer uniqueSubset : uniqueMinTuples) {
            if ((uniqueSubset & subset) == uniqueSubset) {
                return false;
            }
        }

        return true;
    }
}
