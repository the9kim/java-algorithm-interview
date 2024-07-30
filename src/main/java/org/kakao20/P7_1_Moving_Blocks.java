package org.kakao20;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;

public class P7_1_Moving_Blocks {

    static class Robot {
        int x1;
        int y1;
        int x2;
        int y2;
        int dist;
        boolean horiz;

        public Robot(int x1, int y1, int x2, int y2, int dist, boolean horiz) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.dist = dist;
            this.horiz = horiz;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Robot robot = (Robot) o;
            return x1 == robot.x1 && y1 == robot.y1 && x2 == robot.x2 && y2 == robot.y2;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x1, y1, x2, y2);
        }
    }

    /**
     * Runtime Error
     *
     * 1. Check if the robot can move to the 8 types of directions using recursion
     * 2. Find the shortest distance using Dijkstra algorithm
     */
    public int solution(int[][] board) {
        // 1.
        int size = board.length;

        Robot robot = new Robot(0, 0, 1, 0, 0, true);

        Queue<Robot> pq = new PriorityQueue<>(Comparator.comparingInt(r -> r.dist));
        List<Robot> dist = new ArrayList<>();

        pq.add(robot);

        while (!pq.isEmpty()) {
            Robot crnt = pq.poll();

            if (crnt.x2 == size - 1 && crnt.y2 == size - 1) {
                return crnt.dist;
            }

            if (!dist.contains(crnt)) {
                dist.add(crnt);

                int x1 = crnt.x1;
                int y1 = crnt.y1;
                int x2 = crnt.x2;
                int y2 = crnt.y2;
                int d = crnt.dist;
                boolean h = crnt.horiz;


                if (x1 < size && board[y1][x1 + 1] != 1 &&
                        x2 < size - 1 && board[y2][x2 + 1] != 1) {
                    pq.add(new Robot(x1 + 1, y1, x2 + 1, y2, d + 1, h));
                }

                if (x1 > 0 && board[y1][x1 - 1] != 1
                        && x2 > 0 && board[y2][x2 - 1] != 1) {
                    pq.add(new Robot(x1 - 1, y1, x2 - 1, y2, d + 1, h));
                }
                if (y2 < size - 1 && board[y2 + 1][x2] != 1
                        && y1 < size - 1 && board[y1 + 1][x1] != 1) {
                    pq.add(new Robot(x1, y1 + 1, x2, y2 + 1, d + 1, h));
                }
                if (y1 > 0 && board[y1 - 1][x1] != 1
                        && y2 > 0 && board[y2 - 1][x2] != 1) {
                    pq.add(new Robot(x1, y1 - 1, x2, y2 - 1, d + 1, h));
                }
                if (crnt.horiz) {
                    if (y1 < size - 1 && board[y1][x1] != 1 && board[y2 + 1][x2] != 1) {
                        pq.add(new Robot(x1, y1, x2 - 1, y2 + 1, d + 1, false));
                    }
                    if (y1 > 0 && board[y1 - 1][x1] != 1 && board[y2 - 1][x2] != 1) {
                        pq.add(new Robot(x2 - 1, y2 - 1, x1, y1, d + 1, false));
                    }
                    if (y2 > 0 && board[y2 - 1][x2] != 1 && board[y1 - 1][x1] != 1) {
                        pq.add(new Robot(x1 + 1, y1 - 1, x2, y2, d + 1, false));
                    }
                    if (y2 < size - 1 && board[y2 + 1][x2] != 1 && board[y1 + 1][x1] != 1) {
                        pq.add(new Robot(x2, y2, x1 + 1, y1 + 1, d + 1, false));
                    }
                } else if (!crnt.horiz) {
                    if (x1 > 0 && board[y1][x1 - 1] != 1 && board[y2][x2 - 1] != 1) {
                        pq.add(new Robot(x2 - 1, y2 - 1, x1, y1, d + 1, true));
                    }
                    if (x1 < size - 1 && board[y1][x1 + 1] != 1 && board[y2][x2 + 1] != 1) {
                        pq.add(new Robot(x1, y1, x2 + 1, y2 - 1, d + 1, true));
                    }
                    if (x2 < size - 1 && board[y2][x2 + 1] != 1 && board[y1][x1 + 1] != 1) {
                        pq.add(new Robot(x2, y2, x1 + 1, y1 + 1, d + 1, true));
                    }
                    if (x2 > 0 && board[y2][x2 - 1] != 1 && board[y1][x1 - 1] != 1) {
                        pq.add(new Robot(x1 - 1, y1 + 1, x2, y2, d + 1, true));
                    }
                }
            }
        }
        return -1;
    }
}
