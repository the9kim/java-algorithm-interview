package org.kakao22;

import java.util.HashMap;
import java.util.Map;

public class P6_2_Undamaged_Buildings {
    /**
     * Cumulative sum
     *
     * 1. Calculate the cumulative sum for each index
     * 2. Add each cumulative sum to each element of the input Array
     * 3. Calculate the number of elements that are greater than 0
     *
     */

    public int solution(int[][] board, int[][] skill) {
        int rSize = board.length;
        int cSize = board[0].length;

        int[][] delta = new int[rSize + 1][cSize + 1];

        // 1.
        for (int[] s : skill) {
            int degree = s[0] == 1 ? -s[5] : s[5];
            int r1 = s[1];
            int c1 = s[2];
            int r2 = s[3];
            int c2 = s[4];

            delta[r1][c1] += degree;
            delta[r2 + 1][c1] -= degree;
            delta[r1][c2 + 1] -= degree;
            delta[r2 + 1][c2 + 1] += degree;
        }

        for (int c = 0; c < cSize; c++) {
            for (int r = 1; r < rSize; r++) {
                delta[r][c] += delta[r - 1][c];
            }
        }
        for (int r = 0; r < rSize; r++) {
            for (int c = 1; c < cSize; c++) {
                delta[r][c] += delta[r][c - 1];
            }
        }

        // 2 & 3
        int count = 0;

        for (int r = 0; r < rSize; r++) {
            for (int c = 0; c < cSize; c++) {
                board[r][c] += delta[r][c];
                if (board[r][c] > 0) {
                    count++;
                }
            }
        }

        return count;
    }
}
