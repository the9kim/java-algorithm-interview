package org.kakao20;

import java.util.ArrayList;
import java.util.List;

public class P5_3_Installation_of_Pillars_and_Beams {
    static class Grid {
        boolean hasPillar;
        boolean hasBeam;
    }

    Grid[][] board;
    int n;


    public int[][] solution(int n, int[][] build_frame) {

        this.board = new Grid[n + 1][n + 1];
        this.n = n;

        for (int r = 0; r <= n; r++) {
            for (int c = 0; c <= n; c++) {
                board[r][c] = new Grid();
            }
        }

        for (int[] b : build_frame) {
            int x = b[0];
            int y = n - b[1];
            int frame = b[2];
            int command = b[3];

            if (command == 1) {
                if (frame == 0) {
                    if (canConstructPillar(x, y)) {
                        board[y][x].hasPillar = true;
                    }

                } else {
                    if (canConstructBeam(x, y)) {
                        board[y][x].hasBeam = true;
                    }
                }
            } else {
                if (frame == 0) {
                    board[y][x].hasPillar = false;
                    if (!isValidState()) {
                        board[y][x].hasPillar = true;
                    }
                } else {
                    board[y][x].hasBeam = false;
                    if (!isValidState()) {
                        board[y][x].hasBeam = true;
                    }
                }
            }
        }

        List<int[]> answer = new ArrayList<>();

        for (int x = 0; x <= n; x++) {
            for (int y = n; y >= 0; y--) {
                if (board[y][x].hasPillar == true) {
                    answer.add(new int[]{x, n - y, 0});
                }
                if (board[y][x].hasBeam == true) {
                    answer.add(new int[]{x, n - y, 1});
                }
            }
        }

        return answer.toArray(new int[answer.size()][3]);
    }

    private boolean canConstructPillar(int x, int y) {
        if (y == n) {
            return true;
        }

        if (y < n && board[y + 1][x].hasPillar == true) {
            return true;
        }

        if ((board[y][x].hasBeam == true) || (x > 0 && board[y][x - 1].hasBeam == true)) {
            return true;
        }

        return false;
    }

    private boolean canConstructBeam(int x, int y) {
        if (y < n && board[y + 1][x].hasPillar == true) {
            return true;
        }
        if (y < n && x < n && board[y + 1][x + 1].hasPillar == true) {
            return true;
        }
        if (x > 0 && x < n && board[y][x - 1].hasBeam == true && board[y][x + 1].hasBeam == true) {
            return true;
        }

        return false;
    }

    private boolean isValidState() {
        for (int x = 0; x <= n; x++) {
            for (int y = 0; y <= n; y++) {
                if (board[y][x].hasPillar && !canConstructPillar(x, y)) {
                    return false;
                }
                if (board[y][x].hasBeam && !canConstructBeam(x, y)) {
                    return false;
                }
            }
        }
        return true;
    }


    private boolean canRemovePillar(int x, int y) {
        board[y][x].hasPillar = false;

        if (y > 0 && board[y - 1][x].hasPillar == true && !canConstructPillar(x, y - 1)) {
            board[y][x].hasPillar = true;
            return false;
        }

        if (x > 0 && y > 0 && board[y - 1][x - 1].hasBeam == true && !canConstructBeam(x - 1, y - 1)) {
            board[y][x].hasPillar = true;
            return false;
        }

        if (y > 0 && board[y - 1][x].hasBeam == true && !canConstructBeam(x, y - 1)) {
            board[y][x].hasPillar = true;
            return false;
        }

        board[y][x].hasPillar = true;
        return true;
    }


    private boolean canRemoveBeam(int x, int y) {
        board[y][x].hasBeam = false;

        if (x > 0 && board[y][x - 1].hasBeam == true && !canConstructBeam(x - 1, y)) {
            board[y][x].hasBeam = true;
            return false;
        }
        if (x < n && board[y][x + 1].hasBeam == true && !canConstructBeam(x + 1, y)) {
            board[y][x].hasBeam = true;
            return false;
        }

        if (board[y][x].hasPillar == true && !canConstructPillar(x, y)) {
            board[y][x].hasBeam = true;
            return false;
        }

        if (x < n && board[y][x + 1].hasPillar == true && canConstructPillar(x + 1, y)) {
            board[y][x].hasBeam = true;
            return false;
        }

        board[y][x].hasBeam = true;
        return true;
    }

}
