package org.kakao23;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P6_1_Instruction_for_Escaping_Maze {

    static class Point{
        int r;
        int c;
        int dist;
        String commands;

        public Point(int r, int c, int dist, String commands) {
            this.r = r;
            this.c = c;
            this.dist = dist;
            this.commands = commands;
        }
    }

    int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    String[] commands = {"r", "l", "d", "u"};

    /**
     * Time-Exceeded using BFS
     *
     */
    public String solution(int n, int m, int x, int y, int r, int c, int k) {

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y, 0, ""));

        List<String> answer = new ArrayList<>();

        while (!q.isEmpty()) {
            Point curr = q.poll();

            if (curr.r == r && curr.c == c && curr.dist == k) {
                answer.add(curr.commands);
            }

            for (int i = 0; i < 4; i++) {
                int nextRow = curr.r + directions[i][0];
                int nextCol = curr.c + directions[i][1];
                int nextDist = curr.dist + 1;
                String nextCommands = curr.commands + commands[i];

                if (nextRow < 1 || nextRow > n
                        || nextCol < 1 || nextCol > m || nextDist > k) {
                    continue;
                }

                q.add(new Point(nextRow, nextCol, nextDist, nextCommands));
            }
        }

        if (answer.isEmpty()) {
            return "impossible";
        }
        Collections.sort(answer);
        return answer.get(0);
    }
}
