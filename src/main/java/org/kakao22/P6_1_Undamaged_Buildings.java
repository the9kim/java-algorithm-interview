package org.kakao22;

import java.util.HashMap;
import java.util.Map;

public class P6_1_Undamaged_Buildings {
    /**
     * Brute force - Time Exceeded
     *
     * 1. Convert values of the input array, 'board' into a Hashmap
     * 2. Manipulate the values within the HashMap
     * 3. Calculate the count of values in the HashMap that are greater than 0
     */

    public int solution(int[][] board, int[][] skill) {
        // 1.
        Map<Integer, Long> score = new HashMap<>();
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                score.put(r * 1000 + c, (long) board[r][c]);
            }
        }

        // 2.
        for (int[] s : skill) {
            for (int r = s[1]; r <= s[3]; r++) {
                for (int c = s[2]; c <= s[4]; c++) {
                    int idx = r * 1000 + c;
                    if (s[0] == 1) {
                        score.put(idx, score.get(idx) - s[5]);
                    } else {
                        score.put(idx, score.get(idx) + s[5]);
                    }

                }
            }
        }

        // 3.
        return (int) score.values().stream()
                .filter(v -> v > 0)
                .count();
    }
}
