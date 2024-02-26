package org.javaalgorithminterview.ch12;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P35_1_Number_of_IslandsTest {

    @Test
    void numIslands() {
        // given
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };

        // when
        P35_1_Number_of_Islands p35 = new P35_1_Number_of_Islands();
        int answer = p35.numIslands(grid);

        // then
        System.out.println(answer);

    }
}
