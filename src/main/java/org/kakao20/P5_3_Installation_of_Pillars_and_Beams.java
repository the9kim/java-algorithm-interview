package org.kakao20;

import java.util.ArrayList;
import java.util.List;

public class P5_3_Installation_of_Pillars_and_Beams {
    boolean[][] pillars;
    boolean[][] beams;
    int size;

    public int[][] solution(int n, int[][] build_frame) {
        this.pillars = new boolean[n + 1][n + 1];
        this.beams = new boolean[n + 1][n + 1];
        this.size = n + 1;

        construct(build_frame);

        return printFrames();
    }

    private void construct(int[][] build_frame) {

        for (int[] job : build_frame) {
            int x = job[0];
            int y = job[1];
            int frame = job[2];
            int command = job[3];

            if (command == 1) {
                if (frame == 0) {
                    if (canBuildPillar(x, y)) {
                        pillars[y][x] = true;
                    }
                } else {
                    if (canBuildBeam(x,  y)) {
                        beams[y][x] = true;
                    }
                }
            } else {
                if (frame == 0) {
                    pillars[y][x] = false;
                    if (!isValidState()) {
                        pillars[y][x] = true;
                    }
                } else {
                    beams[y][x] = false;
                    if (!isValidState()) {
                        beams[y][x] = true;
                    }
                }
            }
        }

    }

    private int[][] printFrames() {
        List<int[]> results = new ArrayList<>();

        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                if (pillars[y][x]) {
                    results.add(new int[]{x, y, 0});
                }
                if (beams[y][x]) {
                    results.add(new int[]{x, y, 1});
                }
            }
        }

        return results.toArray(new int[results.size()][3]);
    }

    private boolean canBuildPillar(int x, int y) {
        if (y == 0) {
            return true;
        } else if (y > 0 && pillars[y - 1][x]) {
            return true;
        } else if ((beams[y][x]) || (x > 0 && beams[y][x - 1])) {
            return true;
        }

        return false;
    }

    private boolean canBuildBeam(int x, int y) {
        if (y > 0 && pillars[y - 1][x]) {
            return true;
        } else if (y > 0 && x < size - 1 && pillars[y - 1][x + 1]) {
            return true;
        } else if (x > 0 && x < size - 1 && beams[y][x - 1] && beams[y][x + 1]) {
            return true;
        }

        return false;
    }

    private boolean isValidState() {
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                if (pillars[y][x] && !canBuildPillar(x, y)) {
                    return false;
                }
                if (beams[y][x] && !canBuildBeam(x, y)) {
                    return false;
                }
            }
        }
        return true;
    }
}
