package org.kakao18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class P4_2_Friends_4Blocks {

    public int solution(int m, int n, String[] board) {
        int rowSize = m;
        int colSize = n;
        char[][] Board = Arrays.stream(board).map(String::toCharArray).toArray(char[][]::new);

        List<int[]> blocks;
        do {
            blocks = new ArrayList<>();

            // 1. Find the starting point of 4-blocks
            for (int r = 0; r < rowSize - 1; r++) {
                for (int c = 0; c < colSize - 1; c++) {
                    if (Board[r][c] == Board[r + 1][c]
                            && Board[r][c] == Board[r][c + 1]
                            && Board[r][c] == Board[r + 1][c + 1]
                            && Board[r][c] != '#') {
                        blocks.add(new int[]{r, c});
                    }
                }
            }

            // 2. Remove 4-blocks
            for (int[] block : blocks) {
                int r = block[0];
                int c = block[1];

                Board[r][c] = '#';
                Board[r + 1][c] = '#';
                Board[r][c + 1] = '#';
                Board[r + 1][c + 1] = '#';
            }

            // 3. Drop blocks to fill the empty space
            for (int k = 0; k < rowSize; k++) {
                for (int r = 0; r < rowSize - 1; r++) {
                    for (int c = 0; c < colSize; c++) {
                        if (Board[r + 1][c] == '#') {
                            Board[r + 1][c] = Board[r][c];
                            Board[r][c] = '#';
                        }
                    }
                }
            }

        } while (!blocks.isEmpty());


        // 4. Count the empty blocks
        return (int) IntStream.range(0, rowSize)
                .flatMap(r -> IntStream.range(0, colSize)
                        .filter(c -> Board[r][c] == '#'))
                .count();

    }

}
