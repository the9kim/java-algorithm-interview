package org.kakao19;

public class P7_1_Block_Game {

    int[][] board;
    int n;

    /**
     * 1. Slide Two Types of rectangular windows
     * 2. Check if these window contain a block and the block is removable
     * 3. Count the number of removable blocks
     */
    public int solution(int[][] board) {
        this.board = board;
        this.n = board.length;

        int totalRemovals = 0;
        boolean hasRemovedBlocks;

        do {
            hasRemovedBlocks = false;

            // 1
            for (int r = 0; r < n - 2; r++) {
                for (int c = 0; c < n - 1; c++) {

                    // 2.
                    if (canRemove(r, c, 3, 2)) {
                        removeBlock(r, c, 3, 2);
                        hasRemovedBlocks = true;
                        totalRemovals++;
                    }
                }
            }

            for (int r = 0; r < n - 1; r++) {
                for (int c = 0; c < n - 2; c++) {
                    if (canRemove(r, c, 2, 3)) {
                        removeBlock(r, c, 2, 3);
                        hasRemovedBlocks = true;
                        totalRemovals++;
                    }
                }
            }

        } while (hasRemovedBlocks);

        // 3
        return totalRemovals;
    }

    public boolean canRemove(int r, int c, int h, int w) {
        int blockValue = -1;
        int emptyCounts = 0;

        for (int row = r; row < r + h; row++) {
            for (int col = c; col < c + w; col++) {
                if (board[row][col] == 0) {
                    if (emptyCounts >= 2 || !isEmptyAbove(row, col)) {
                        return false;
                    }
                    emptyCounts++;

                } else {
                    if (blockValue != -1 && blockValue != board[row][col]) {
                        return false;
                    }
                    blockValue = board[row][col];
                }
            }
        }
        return blockValue != -1;
    }

    public boolean isEmptyAbove(int r, int c) {
        while (r >= 0) {
            if (board[r][c] != 0) {
                return false;
            }
            r--;
        }
        return true;
    }

    public void removeBlock(int r, int c, int h, int w) {
        if (r + h > n || c + w > n) {
            return;
        }

        for (int row = r; row < r + h; row++) {
            for (int col = c; col < c + w; col++) {
                board[row][col] = 0;
            }
        }
    }

}
