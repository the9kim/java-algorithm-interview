package org.kakao21;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P6_1_Card_Matching {

    /**
     * 1. Calculate the permutations regarding of the order of flipping the cards
     * 2. Calculate the number of cursor movements for each permutation using BFS
     * 3. Determine the minimum number of key manipulations
     */

    static class Point {
        int row;
        int col;
        int cnt;

        public Point(int row, int col, int cnt) {
            this.row = row;
            this.col = col;
            this.cnt = cnt;
        }
    }

    int[][] D = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    int[][] board;
    int size;

    public int solution(int[][] board, int r, int c) {
        this.board = board;
        this.size = board.length;

        Point point = new Point(r, c, 0);

        // 1.
        return permute(point);
    }

    public int permute(Point curr) {

        int minCnt = Integer.MAX_VALUE;

        for (int s = 1; s <= 6; s++) {
            List<Point> cards = new ArrayList<>();
            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    if (board[row][col] == s) {
                        cards.add(new Point(row, col, 0));
                    }
                }
            }

            if (cards.isEmpty()) {
                continue;
            }

            // 2.
            int cnt1 = bfs(curr, cards.get(0)) + bfs(cards.get(0), cards.get(1)) + 2;
            int cnt2 = bfs(curr, cards.get(1)) + bfs(cards.get(1), cards.get(0)) + 2;

            for (int i = 0; i < 2; i++) {
                board[cards.get(i).row][cards.get(i).col] = 0;
            }

            minCnt = Math.min(minCnt, cnt1 + permute(cards.get(1)));
            minCnt = Math.min(minCnt, cnt2 + permute(cards.get(0)));

            for (int i = 0; i < 2; i++) {
                board[cards.get(i).row][cards.get(i).col] = s;
            }
        }
        if (minCnt == Integer.MAX_VALUE) {
            return 0;
        }

        return minCnt;
    }

    public int bfs(Point src, Point dst) {
        boolean[][] visited = new boolean[size][size];

        Queue<Point> q = new LinkedList<>();
        q.add(src);
        visited[src.row][src.col] = true;

        while (!q.isEmpty()) {
            Point curr = q.poll();
            if (curr.row == dst.row && curr.col == dst.col) {
                return curr.cnt;
            }

            for (int i = 0; i < 4; i++) {
                int nextRow = curr.row + D[i][0];
                int nextCol = curr.col + D[i][1];

                if (nextRow < 0 || nextRow > size - 1 || nextCol < 0 || nextCol > size - 1) {
                    continue;
                }
                if (!visited[nextRow][nextCol]) {
                    visited[nextRow][nextCol] = true;
                    q.add(new Point(nextRow, nextCol, curr.cnt + 1));
                }

                for (int n = 0; n < 2; n++) {
                    if (board[nextRow][nextCol] != 0) {
                        break;
                    }
                    if ((nextRow + D[i][0]) < 0 || (nextRow + D[i][0]) > size - 1
                            || (nextCol + D[i][1]) < 0 || (nextCol + D[i][1]) > size - 1) {
                        break;
                    }
                    nextRow += D[i][0];
                    nextCol += D[i][1];
                }
                if (!visited[nextRow][nextCol]) {
                    visited[nextRow][nextCol] = true;
                    q.add(new Point(nextRow, nextCol, curr.cnt + 1));
                }
            }
        }
        return 0;
    }
}
