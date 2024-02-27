package org.javaalgorithminterview.ch12_graph;

public class P35_1_Number_of_Islands {

    public void dfs(char[][] grid, int row, int column) {
        grid[row][column] = '0';

        if (column + 1 < grid[0].length && grid[row][column + 1] == '1') {
            dfs(grid, row, column + 1);
        }

        if (row + 1 < grid.length && grid[row + 1][column] == '1') {
            dfs(grid, row + 1, column);
        }

        if (row - 1 >= 0 && grid[row - 1][column] == '1') {
            dfs(grid, row - 1, column);
        }
        if (column - 1 >= 0 && grid[row][column - 1] == '1') {
            dfs(grid, row, column - 1);
        }
    }

    public int numIslands(char[][] grid) {
        int count = 0;

        if (grid.length == 0) {
            return count;
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * The book solution
     *
     * This solution improves readability.
     */
    public void dfs2(char[][] grid, int row, int column) {
        if (column >= grid[0].length
                || row >= grid.length
                || row < 0
                || column < 0
                || grid[row][column] == '0') {
         return;
        }

        grid[row][column] = '0';

        dfs2(grid, row, column + 1);
        dfs2(grid, row + 1, column);
        dfs2(grid, row - 1, column);
        dfs2(grid, row, column - 1);
    }
    public int numIslands2(char[][] grid) {
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs2(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
}
