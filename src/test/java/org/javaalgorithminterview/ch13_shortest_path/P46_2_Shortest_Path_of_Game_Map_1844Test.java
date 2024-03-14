package org.javaalgorithminterview.ch13_shortest_path;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class P46_2_Shortest_Path_of_Game_Map_1844Test {

    @Test
    void calculateRunningTime() {

        int[][] maps = {
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 1},
                {0, 0, 0, 0, 1}
        };

        P46_2_Shortest_Path_of_Game_Map_1844 p46 = new P46_2_Shortest_Path_of_Game_Map_1844();

        long startTime = System.nanoTime();

        p46.solution(maps);

        long endTime = System.nanoTime();

        System.out.println("Running Time: " + (double) (endTime - startTime) / 1_000_000 + " ms");

    }

    @Test
    void searchShortestRoute_shouldSucceed() {
        // given
        int[][] maps = {
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 1},
                {0, 0, 0, 0, 1}
        };

        int expectedDistance = 11;

        // when
        P46_2_Shortest_Path_of_Game_Map_1844 p46 = new P46_2_Shortest_Path_of_Game_Map_1844();
        int distance = p46.solution(maps);

        // then
        Assertions.assertThat(distance).isEqualTo(expectedDistance);
    }

}
