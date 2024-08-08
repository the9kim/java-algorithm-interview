package org.kakao23;

public class P6_2_Instruction_for_Escaping_Maze {

    String answer = null;
    StringBuilder route = new StringBuilder();

    int N;
    int M;
    int dstRow;
    int dstCol;
    int k;

    int[][] directions = {{1, 0}, {0, -1}, {0, 1}, {-1, 0}};
    String[] commands = {"d", "l", "r", "u"};


    /**
     * DFS with Pruning
     */

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        N = n;
        M = m;
        dstRow = r;
        dstCol = c;
        this.k = k;

        int distance = getDistance(x, y, r, c);

        if (distance > k || (k - distance) % 2 != 0) {
            return "impossible";
        }

        dfs(x, y, 0);

        return answer;
    }
    private int getDistance(int r1, int c1, int r2, int c2) {
        return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    }

    public void dfs(int r, int c, int step) {
        if (answer != null) {
            return;
        }
        if (k - step < getDistance(r, c, dstRow, dstCol)) {
            return;
        }

        if (step == k) {
            answer = route.toString();
            return;
        }

        for (int dir = 0; dir < 4; dir++) {
            int nextR = r + directions[dir][0];
            int nextC = c + directions[dir][1];
            int nextDist = step + 1;

            if (nextR < 1 || nextR > N || nextC < 1 || nextC > M) {
                continue;
            }
            route.append(commands[dir]);
            dfs(nextR, nextC, nextDist);
            route.deleteCharAt(step);
        }
    }


}
