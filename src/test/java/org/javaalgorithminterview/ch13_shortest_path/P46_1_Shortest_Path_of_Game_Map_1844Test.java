package org.javaalgorithminterview.ch13_shortest_path;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

class P46_1_Shortest_Path_of_Game_Map_1844Test {

    @Test
    void calculateRunningTime() {

        int[][] maps = {
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 1},
                {0, 0, 0, 0, 1}
        };

        P46_1_Shortest_Path_of_Game_Map_1844 p46 = new P46_1_Shortest_Path_of_Game_Map_1844();

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
        P46_1_Shortest_Path_of_Game_Map_1844 p46 = new P46_1_Shortest_Path_of_Game_Map_1844();
        int distance = p46.solution(maps);

        // then
        Assertions.assertThat(distance).isEqualTo(expectedDistance);
    }

    @Test
    void searchShortestRoute_shouldFail() {
        // given
        int[][] maps = {
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 0},
                {0, 0, 0, 0, 1}
        };

        int expectedDistance = -1;

        // when
        P46_1_Shortest_Path_of_Game_Map_1844 p46 = new P46_1_Shortest_Path_of_Game_Map_1844();
        int distance = p46.solution(maps);

        // then
        Assertions.assertThat(distance).isEqualTo(expectedDistance);
    }


    @Test
    void createGraph() {

        // given
        int[][] maps = {
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 1},
                {0, 0, 0, 0, 1}
        };

        // when
        P46_1_Shortest_Path_of_Game_Map_1844 p46 = new P46_1_Shortest_Path_of_Game_Map_1844();

        Map<List<Integer>, List<List<Integer>>> graph = p46.createGraph(maps);

        // then
        System.out.println(graph);
    }

    @Test
    void searchTheShortestRoute() {
        // given
        int[][] maps = {
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 1},
                {0, 0, 0, 0, 1}
        };

        P46_1_Shortest_Path_of_Game_Map_1844 p46 = new P46_1_Shortest_Path_of_Game_Map_1844();
        Map<List<Integer>, List<List<Integer>>> graph = p46.createGraph(maps);

        int expectedDistance = 11;

        // when
        int distance = p46.searchRoute(graph, maps);

        // then
        System.out.println(distance);

        Assertions.assertThat(distance).isEqualTo(expectedDistance);
    }
}
