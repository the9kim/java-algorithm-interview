package org.kakao21;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class P6_2_Card_Matching {

    static class Point {
        int row;
        int col;
        int dist;

        public Point(int row, int col, int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }

    int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int[][] board;
    int n;
    Map<Integer, List<Point>> cards;

    public int solution(int[][] board, int r, int c) {
        this.board = board;
        this.n = board.length;
        this.cards = new HashMap<>();

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (board[row][col] == 0) {
                    continue;
                }
                cards.putIfAbsent(board[row][col], new ArrayList<>());
                cards.get(board[row][col]).add(new Point(row, col, 0));
            }
        }

        return findCards(new Point(r, c, 0));
    }

    public int findCards(Point src) {
        if (cards.isEmpty()) {
            return 0;
        }

        int minMani = Integer.MAX_VALUE;

        for (int n = 1; n <= 6; n++) {
            if (!cards.containsKey(n)) {
                continue;
            }

            List<Point> currCards = new ArrayList<>(cards.get(n));
            Point card1 = currCards.get(0);
            Point card2 = currCards.get(1);

            int cnt1 = calManiCount(src, card1) + calManiCount(card1, card2) + 2;
            int cnt2 = calManiCount(src, card2) + calManiCount(card2, card1) + 2;

            cards.remove(n);

            minMani = Math.min(minMani, cnt1 + findCards(card2));
            minMani = Math.min(minMani, cnt2 + findCards(card1));

            cards.put(n, currCards);
        }

        return minMani;
    }

    public int calManiCount(Point src, Point dst) {
        boolean[][] visited = new boolean[n][n];
        Queue<Point> q = new LinkedList<>();
        q.add(src);
        visited[src.row][src.col] = true;

        while (!q.isEmpty()) {
            Point curr = q.poll();

            if (curr.row == dst.row && curr.col == dst.col) {
                return curr.dist;
            }

            for (int d = 0; d < 4; d++) {
                int nextRow = curr.row + directions[d][0];
                int nextCol = curr.col + directions[d][1];
                int nextDist = curr.dist + 1;

                if (nextRow < 0 || nextCol < 0 || nextRow >= n || nextCol >= n) {
                    continue;
                }

                if (!visited[nextRow][nextCol]) {
                    visited[nextRow][nextCol] = true;
                    q.add(new Point(nextRow, nextCol, nextDist));
                }

                for (int i = 0; i < 2; i++) {
                    if (cards.containsKey(board[nextRow][nextCol])) {
                        break;
                    }
                    if (nextRow + directions[d][0] < 0 || nextCol + directions[d][1] < 0
                            || nextRow + directions[d][0] >= n || nextCol + directions[d][1] >= n) {
                        break;
                    }
                    nextRow += directions[d][0];
                    nextCol += directions[d][1];
                }
                if (!visited[nextRow][nextCol]) {
                    visited[nextRow][nextCol] = true;
                    q.add(new Point(nextRow, nextCol, nextDist));
                }
            }
        }
        return -1;
    }
}
