package org.javaalgorithminterview.ch18_binary_search;

import java.util.Arrays;

public class P74_1_Search_a_2D_Matrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int colEnd = matrix[0].length - 1;

        for (int[] row : matrix) {
            if (target > row[colEnd]) {
                continue;
            }
            int expected = Arrays.binarySearch(row, target);
            if (expected >= 0) {
                return true;
            }
        }
        return false;
    }

}
