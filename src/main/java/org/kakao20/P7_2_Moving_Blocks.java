package org.kakao20;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;

import static java.util.Collections.rotate;

public class P7_2_Moving_Blocks {

    /**
     * 1. Insert position moved in a straight line and by rotation into a queue
     * 2. Determine the distance to the final destination using BFS
     */

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

    int[][] D = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int[][][] Drot = {{{1, 1}, {1, -1}, {-1, -1}, {-1, 1}},
            {{1, -1}, {-1, -1}, {-1, 1}, {1, 1}}};
    int[][][] Dcor = {{{-1, 1}, {1, 1}, {1, -1}, {-1, -1}},
            {{-1, -1}, {-1, 1}, {1, 1}, {1, -1}}};

    int[][] board;
    int size;
    Queue<Point[]> q;
    boolean[][][] visited;

    public int solution(int[][] board) {
        this.board = board;
        size = board.length;
        q = new LinkedList<>();
        visited = new boolean[4][size][size];

        q.add(new Point[]{
                new Point(0, 0, RIGHT, 0),
                new Point(0, 1, LEFT, 0)
        });
        visited[RIGHT][0][0] = true;
        visited[LEFT][0][1] = true;

        // 1.
        while (!q.isEmpty()) {
            Point[] curr = q.poll();

            int ret = moveStraight(curr);
            if (ret != -1) {
                return ret;
            }

            int ret2 = rotate(curr);
            if (ret2 != -1) {
                return ret;
            }
        }
        return -1;
    }

    public int moveStraight(Point[] curr) {
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
            if (!isValid(next)) {
                continue;
            }
            for (int p = 0; p < 2; p++) {
                if (next[p].row == size - 1 && next[p].col == size - 1) {
                    return next[p].time;
                }
                visited[next[p].dir][next[p].row][next[p].col] = true;
            }
            q.add(next);
        }
        return -1;
    }

    public int rotate(Point[] curr) {
        for (int ccd = 0; ccd < 2; ccd++) {
            for (int p = 0; p < 2; p++) {
                Point[] next = new Point[2];
                int pivot = p;
                int rotated = (p + 1) % 2;

                next[pivot] = new Point(
                        curr[pivot].row,
                        curr[pivot].col,
                        (curr[pivot].dir + (ccd == 0 ? 1: 3)) % 4,
                        curr[pivot].time + 1
                );
                next[rotated] = new Point(
                        curr[rotated].row + Drot[ccd][curr[pivot].dir][0],
                        curr[rotated].col + Drot[ccd][curr[pivot].dir][1],
                        (curr[rotated].dir + (ccd == 0 ? 1 : 3)) % 4,
                        curr[rotated].time + 1
                );
                if (!isValid(next)) {
                    continue;
                }

                if (board[next[pivot].row + Dcor[ccd][curr[pivot].dir][0]][next[pivot].col + Dcor[ccd][curr[pivot].dir][1]] == 1) {
                    continue;
                }
                for (int i = 0; i < 2; i++) {
                    if (next[i].row == size - 1 && next[i].col == size - 1) {
                        return next[i].time;
                    }
                    visited[next[i].dir][next[i].row][next[i].col] = true;
                }
                q.add(next);
            }
        }
        return -1;
    }

    public boolean isValid(Point[] points) {
        for (int p = 0; p < 2; p++) {
            Point point = points[p];

            if (point.row < 0 || point.row > size - 1 || point.col < 0 || point.col > size - 1) {
                return false;
            }
            if (board[point.row][point.col] == 1) {
                return false;
            }
            if (visited[point.dir][point.row][point.col] == true) {
                return false;
            }
        }
        return true;
    }

}
