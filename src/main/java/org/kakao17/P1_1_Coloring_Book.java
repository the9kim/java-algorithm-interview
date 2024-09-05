package org.kakao17;

public class P1_1_Coloring_Book {

    /**
     * 1. Find an area within the grid using Depth-First Search (DFS).
     * 2. Calculate the total number of distinct areas and determine the maximum area size.
     */

    public int[] solution(int m, int n, int[][] picture) {

        int maxArea = Integer.MIN_VALUE;
        int areaCount = 0;

        // step 1
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (picture[r][c] != 0) {
                    int blocks = dfs(r, c, picture, picture[r][c]);
                    // step 2
                    areaCount++;
                    maxArea = Math.max(maxArea, blocks);
                }

            }
        }
        return new int[]{areaCount, maxArea};
    }

    private int dfs(int row, int col, int[][] board, int areaValue) {
        if (row < 0 || row >= board.length
                || col < 0 || col >= board[0].length
                || board[row][col] == 0 || board[row][col] != areaValue) {
            return 0;
        }

        int count = 1;

        board[row][col] = 0;

        count += dfs(row, col + 1, board, areaValue);
        count += dfs(row + 1, col, board, areaValue);
        count += dfs(row, col - 1, board, areaValue);
        count += dfs(row - 1, col, board, areaValue);

        return count;
    }
}
