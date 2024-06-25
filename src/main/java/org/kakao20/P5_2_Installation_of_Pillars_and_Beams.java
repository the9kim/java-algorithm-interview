package org.kakao20;

import java.util.ArrayList;
import java.util.List;

public class P5_2_Installation_of_Pillars_and_Beams {

    boolean[][] pillars;
    boolean[][] beams;

    // 1. Build the pillows and the beams after checking conditions
    // 2. Remove the pillows and the beams after checking conditions
    // 3. Combine the pillows and the beams then sort them.
    public int[][] solution(int n, int[][] build_frame) {

        this.pillars = new boolean[n + 1][n + 1];
        this.beams = new boolean[n + 1][n + 1];


        int count = 0;
        for (int[] frame : build_frame) {
            int x = frame[0], y = frame[1];
            int shape = frame[2], operation = frame[3];

            // 1.
            if (operation == 1) {
                if (shape == 0) {
                    if (canPillar(x, y)) {
                        this.pillars[x][y] = true;
                        count++;
                    }
                } else if (shape == 1) {
                    if (canBeam(x, y)) {
                        this.beams[x][y] = true;
                        count++;
                    }
                }
            // 2.
            } else if (operation == 0) {
                if (shape == 0) {
                    this.pillars[x][y] = false;
                    if (!canRemove(x, y)) {
                        this.pillars[x][y] = true;
                    } else {
                        count--;
                    }
                } else if (shape == 1) {
                    this.beams[x][y] = false;
                    if (!canRemove(x, y)) {
                        this.beams[x][y] = true;
                    } else {
                        count--;
                    }
                }
            }
        }

        // 3.
        int[][] answer = new int[count][3];
        count = 0;

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (this.pillars[i][j] == true) {
                    answer[count] = new int[]{i, j, 0};
                    count++;
                }
                if (this.beams[i][j] == true) {
                    answer[count] = new int[]{i, j, 1};
                    count++;
                }
            }
        }
        return answer;
    }

    /**
     * Check if, when a pillar or a beam is deleted, elements that depend on the deleted one can still be constructed
     */
    private boolean canRemove(int x, int y) {
        for (int row = Math.max(x - 1, 0); row <= x + 1; row++) {
            for (int col = y; col <= Math.min(y + 1, this.pillars.length - 1); col++) {
                if (this.pillars[row][col] == true && canPillar(row, col) == false) {
                    return false;
                }
                if (this.beams[row][col] == true && canBeam(row, col) == false) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean canBeam(int x, int y) {
        if ((y > 0 && x < this.beams.length - 1 && this.pillars[x + 1][y - 1])
                || (y > 0 && this.pillars[x][y - 1])) {
            return true;
        }
        if ((x > 0 && this.beams[x - 1][y])
                && (x < beams.length - 1 && this.beams[x + 1][y])) {
            return true;
        }
        return false;
    }

    private boolean canPillar(int x, int y) {
        if (y == 0 || this.pillars[x][y - 1] == true) {
            return true;
        }
        if ((x > 0 && this.beams[x - 1][y]) || this.beams[x][y]) {
            return true;
        }
        return false;
    }

}
