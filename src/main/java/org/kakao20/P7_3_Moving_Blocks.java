package org.kakao20;

import java.util.LinkedList;
import java.util.Queue;

public class P7_3_Moving_Blocks {
    static class Point {
        int row;
        int col;
        int dir;
        int time;

        public Point(int row, int col, int dir, int time) {
            this.row = row;
            this.col = col;
            this.dir = dir;
            this.time = time;
        }
    }

    static final int UP = 0;
    static final int RIGHT = 1;
    static final int DOWN = 2;
    static final int LEFT = 3;

    int[][] D = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    int[][][] Drot = {{{1, 1}, {1, -1}, {-1, -1}, {-1, 1}},
            {{1, -1}, {-1, -1}, {-1, 1}, {1, 1}}};
    int[][][] Dcor = {{{-1, 1}, {1, 1}, {1, -1}, {-1, -1}},
            {{-1, -1}, {-1, 1}, {1, 1}, {1, -1}}};

    int[][] board;
    int size;
    boolean[][][] visited;
    Queue<Point[]> q;

    public int solution(int[][] board) {
        this.board = board;
        this.size = board.length;
        this.visited = new boolean[4][size][size];
        q = new LinkedList<>();

        q.add(new Point[]{
                new Point(0, 0, RIGHT, 0), new Point(0, 1, LEFT, 0)
        });

        visited[RIGHT][0][0] = true;
        visited[LEFT][0][1] = true;

        while (!q.isEmpty()) {
            Point[] curr = q.poll();

            // 1. Move the robot and insert its position to a queue
            for (int d = 0; d < 4; d++) {
                Point[] next = new Point[2];
                for (int p = 0; p < 2; p++) {
                    next[p] = new Point(
                            curr[p].row + D[d][0],
                            curr[p].col + D[d][1],
                            curr[p].dir,
                            curr[p].time + 1
                    );
                }
                if (!canMove(next)) {
                    continue;
                }

                // 2. Update visited route
                int isAnswer = updateRoute(next);

                // 3. Find the shortest time to the destination
                if (isAnswer != -1) {
                    return isAnswer;
                }
                q.add(next);
            }

            for (int ccd = 0; ccd < 2; ccd++) {
                for (int piv = 0; piv < 2; piv++) {
                    Point[] next = new Point[2];

                    int pivot = piv;
                    int rotated = (piv + 1) % 2;

                    next[pivot] = new Point(
                            curr[pivot].row,
                            curr[pivot].col,
                            (curr[pivot].dir + (ccd == 0 ? 1 : 3)) % 4,
                            curr[pivot].time + 1
                    );

                    next[rotated] = new Point(
                            curr[rotated].row + Drot[ccd][curr[pivot].dir][0],
                            curr[rotated].col + Drot[ccd][curr[pivot].dir][1],
                            (curr[rotated].dir + (ccd == 0 ? 1 : 3)) % 4,
                            curr[rotated].time + 1
                    );

                    if (!canMove(next)) {
                        continue;
                    }

                    int row = curr[pivot].row + Dcor[ccd][curr[pivot].dir][0];
                    int col = curr[pivot].col + Dcor[ccd][curr[pivot].dir][1];

                    if (board[row][col] == 1) {
                        continue;
                    }

                    int isAnswer = updateRoute(next);
                    if (isAnswer != -1) {
                        return isAnswer;
                    }

                    q.add(next);
                }
            }
        }
        return -1;
    }

    public boolean canMove(Point[] curr) {
        for (int p = 0; p < 2; p++) {
            if (curr[p].row < 0 || curr[p].row > size - 1 || curr[p].col < 0 || curr[p].col > size - 1) {
                return false;
            }
            if (board[curr[p].row][curr[p].col] == 1) {
                return false;
            }
            if (visited[curr[p].dir][curr[p].row][curr[p].col] == true) {
                return false;
            }
        }
        return true;
    }

    public int updateRoute(Point[] curr) {
        for (int p = 0; p < 2; p++) {
            if (curr[p].row == size - 1 && curr[p].col == size - 1) {
                return curr[p].time;
            }
            visited[curr[p].dir][curr[p].row][curr[p].col] = true;
        }
        return -1;
    }

}
