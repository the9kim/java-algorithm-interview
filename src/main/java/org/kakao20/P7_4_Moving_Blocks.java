package org.kakao20;

import java.util.LinkedList;
import java.util.Queue;

public class P7_4_Moving_Blocks {

    static class Point {
        int direction;
        int row;
        int col;
        int dist;

        public Point(int direction, int row, int col, int dist) {
            this.direction = direction;
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }

    static final int UP = 0;
    static final int RIGHT = 1;
    static final int DOWN = 2;
    static final int LEFT = 3;

    int[][] board;
    int N;
    Queue<Point[]> q;
    boolean[][][] visited;

    int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    int[][][] rotations = {
            {{1, 1}, {1, -1}, {-1, -1}, {-1, 1}},
            {{1, -1}, {-1, -1}, {-1, 1}, {1, 1}}
    };
    int[][][] corners = {
            {{-1, 1}, {1, 1}, {1, -1}, {-1, -1}},
            {{-1, -1}, {-1, 1}, {1, 1}, {1, -1}}
    };


    public int solution(int[][] board) {
        this.board = board;
        this.N = board.length;
        this.q = new LinkedList<>();
        this.visited = new boolean[4][N][N];

        visited[RIGHT][0][0] = true;
        visited[LEFT][0][1] = true;
        q.add(new Point[]{
                new Point(RIGHT, 0, 0, 0),
                new Point(LEFT, 0, 1, 0)
        });

        while (!q.isEmpty()) {
            Point[] currPoints = q.poll();

            for (int dir = 0; dir <= 3; dir++) {

                Point[] nextPoints = new Point[2];

                for (int p = 0; p <= 1; p++) {
                    nextPoints[p] = new Point(
                            currPoints[p].direction,
                            currPoints[p].row + directions[dir][0],
                            currPoints[p].col + directions[dir][1],
                            currPoints[p].dist + 1
                    );
                }

                if (canMove(nextPoints)) {
                    if (isDestination(nextPoints)) {
                        return nextPoints[0].dist;
                    }
                    updateRoute(nextPoints);
                    q.add(nextPoints);
                }
            }

            for (int cw = 0; cw <= 1; cw++) {
                for (int pivIdx = 0; pivIdx <= 1; pivIdx++) {

                    Point[] nextPoints = new Point[2];
                    int rotatedIdx = (pivIdx + 1) % 2;
                    Point pivot = currPoints[pivIdx];
                    Point rotated = currPoints[rotatedIdx];

                    nextPoints[pivIdx] = new Point(
                            (pivot.direction + (cw == 0 ? 1 : 3)) % 4,
                            pivot.row,
                            pivot.col,
                            pivot.dist + 1
                    );

                    nextPoints[rotatedIdx] = new Point(
                            (rotated.direction + (cw == 0 ? 1 : 3)) % 4,
                            rotated.row + rotations[cw][pivot.direction][0],
                            rotated.col + rotations[cw][pivot.direction][1],
                            rotated.dist + 1
                    );

                    if (canMove(nextPoints) && canRotate(pivot, cw)) {
                        if (isDestination(nextPoints)) {
                            return nextPoints[0].dist;
                        }
                        updateRoute(nextPoints);
                        q.add(nextPoints);
                    }
                }
            }
        }
        return -1;
    }

    public boolean canMove(Point[] points) {
        for (Point p : points) {
            if (p.row < 0 || p.col < 0 || p.row > N - 1 || p.col > N - 1) {
                return false;
            }
            if (board[p.row][p.col] == 1) {
                return false;
            }
            if (visited[p.direction][p.row][p.col]) {
                return false;
            }
        }
        return true;
    }

    public void updateRoute(Point[] points) {
        for (Point p : points) {
            visited[p.direction][p.row][p.col] = true;
        }
    }

    public boolean isDestination(Point[] points) {
        for (Point p : points) {
            if (p.row == N - 1 && p.col == N - 1) {
                return true;
            }
        }
        return false;
    }

    public boolean canRotate(Point pivot, int cw) {
        int cornerRow = pivot.row + corners[cw][pivot.direction][0];
        int cornerCol = pivot.col + corners[cw][pivot.direction][1];

        if (cornerRow < 0 || cornerCol < 0 || cornerRow >= N || cornerCol >= N) {
            return false;
        }


        if (board[cornerRow][cornerCol] == 1) {
            return false;
        }
        return true;
    }

}
