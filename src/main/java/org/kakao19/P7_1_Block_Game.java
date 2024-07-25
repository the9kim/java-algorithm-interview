package org.kakao19;

public class P7_1_Block_Game {

    /**
     * 1. Slide Two Types of rectangular windows
     * 2. Check if these window contain a block and the block is removable
     * 3. Count the number of removable blocks
     */

    int[][] board;
    int size;

    public int solution(int[][] board) {
        this.board = board;
        size = board.length;
        int answer = 0;

        int count;
        // 1.
        do {
            count = 0;
            for (int r = 0; r < size; r++) {
                for (int c = 0; c < size; c++) {
                    if (r < size - 1 && c < size - 2 && canRemove(r, c, 3, 2)) {
                        count++;
                        remove(r, c, 3, 2);
                    }
                    if (r < size - 2 && c < size - 1 && canRemove(r, c, 2, 3)) {
                        count++;
                        remove(r, c, 2, 3);
                    }
                }
            }
            answer += count;

        } while (count != 0);

        return answer;
    }

    public boolean canRemove(int row, int col, int width, int height) {
        int emptyNum = 0;
        int lastValue = -1;

        for (int r = row; r < row + height; r++) {
            for (int c = col; c < col + width; c++) {
                if (board[r][c] == 0) {
                    if (emptyNum >= 2) {
                        return false;
                    }
                    if (!isEmptyAbove(r, c)) {
                        return false;
                    }
                    emptyNum++;
                } else {
                    if (lastValue != -1 && board[r][c] != lastValue) {
                        return false;
                    }
                    lastValue = board[r][c];
                }
            }
        }
        return true;
    }

    public boolean isEmptyAbove(int row, int col) {
        while (row >= 0) {
            if (board[row][col] != 0) {
                return false;
            }
            row--;
        }
        return true;
    }

    public void remove(int row, int col, int w, int h) {
        for (int r = row; r < row + h; r++) {
            for (int c = col; c < col + w; c++) {
                board[r][c] = 0;
            }
        }
    }
}
