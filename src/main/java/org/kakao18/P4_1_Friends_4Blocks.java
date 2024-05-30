package org.kakao18;

import java.util.LinkedList;
import java.util.Queue;

public class P4_1_Friends_4Blocks {

    public int solution(int m, int n, String[] board) {
        // 1. Convert the input array to a 2-D matrix
        char[][] matrix = new char[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = board[i].charAt(j);
            }
        }
        int totalNums = 0;

        while (true) {
            int nums = 0;

            // 2. Find 4-blocks and mark them
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    nums += findBlocks(matrix, i, j);
                }
            }

            // If there is no 4-blocks, break this roof
            if (nums == 0) {
                break;
            } else {
                totalNums += nums;
            }

            // 3. Rearrange blocks in the matrix
            for (int i = m - 2; i >= 0; i--) {
                for (int j = 0; j < n; j++) {
                    rearrange(matrix, i, j);
                }
            }
        }
        return totalNums;
    }

    private int findBlocks(char[][] matrix, int row, int col) {
        if (matrix[row][col] == '0'
                || matrix[row][col] != matrix[row + 1][col]
                || matrix[row][col] != matrix[row][col + 1]
                || matrix[row][col] != matrix[row + 1][col + 1]) {
            return 0;
        }

        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{row, col});

        int num = 0;

        while (!q.isEmpty()) {
            int[] indices = q.poll();
            row = indices[0];
            col = indices[1];
            char e = matrix[row][col];

            // To prevent duplicated counting
            if (matrix[row][col] != '0') {
                matrix[row][col] = '0';
                num++;
            }

            if (row + 1 >= matrix.length
                    || col + 1 >= matrix[0].length
                    || e != matrix[row + 1][col]
                    || e != matrix[row][col + 1]
                    || e != matrix[row + 1][col + 1]) {
                continue;
            }

            q.add(new int[]{row + 1, col});
            q.add(new int[]{row, col + 1});
            q.add(new int[]{row + 1, col + 1});
        }
        return num;
    }

    private void rearrange(char[][] matrix, int row, int col) {
        Character c = matrix[row][col];

        if (row + 1 >= matrix.length || matrix[row + 1][col] != '0') {
            return;
        }

        matrix[row + 1][col] = c;
        matrix[row][col] = '0';

        rearrange(matrix, row + 1, col);
    }
}
