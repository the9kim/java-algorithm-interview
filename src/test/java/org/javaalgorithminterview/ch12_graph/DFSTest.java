package org.javaalgorithminterview.ch12_graph;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

class DFSTest {

    @Test
    void dfs() {
        // given
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(1, List.of(2, 3, 4));
        graph.put(2, List.of(5));
        graph.put(3, List.of(5));
        graph.put(4, List.of());
        graph.put(5, List.of(6, 7));
        graph.put(6, List.of());
        graph.put(7, List.of(3));

        DFS dfs = new DFS(graph);

        // when
        List<Integer> discovered = new ArrayList<>();
        List<Integer> path = dfs.recursiveDFS(1, discovered);

        // then
        System.out.println(path);

    }

    @Test
    void dfs2() {
        // given
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(1, List.of(2, 3, 4));
        graph.put(2, List.of(5));
        graph.put(3, List.of(5));
        graph.put(4, List.of());
        graph.put(5, List.of(6, 7));
        graph.put(6, List.of());
        graph.put(7, List.of(3));

        DFS dfs = new DFS(graph);

        // when
        List<Integer> discovered = new ArrayList<>();
        List<Integer> path = dfs.iterativeDFS(1);

        // then
        System.out.println(path);

    }
}
