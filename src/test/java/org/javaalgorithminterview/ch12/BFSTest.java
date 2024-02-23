package org.javaalgorithminterview.ch12;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class BFSTest {

    @Test
    void bfs() {
        // given
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(1, List.of(2, 3, 4));
        graph.put(2, List.of(5));
        graph.put(3, List.of(5));
        graph.put(4, List.of());
        graph.put(5, List.of(6, 7));
        graph.put(6, List.of());
        graph.put(7, List.of(3));

        BFS dfs = new BFS(graph);

        // when
        List<Integer> path = dfs.iterativeBFS(1);

        // then
        System.out.println(path);

    }

}
