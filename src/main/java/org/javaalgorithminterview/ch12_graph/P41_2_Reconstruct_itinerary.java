package org.javaalgorithminterview.ch12_graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;


/**
 * The method using recursion
 */
public class P41_2_Reconstruct_itinerary {

    public void dfs(List<String> result, Map<String, PriorityQueue<String>> graph, String from) {
        while (graph.containsKey(from) && !graph.get(from).isEmpty()) {
            dfs(result, graph, graph.get(from).poll());
        }
        result.add(0, from);
    }

    public List<String> findItinerary(List<List<String>> tickets) {

        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for (List<String> ticket : tickets) {
            graph.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            graph.get(ticket.get(0)).add(ticket.get(1));
        }

        List<String> result = new ArrayList<>();
        dfs(result, graph, "JFK");

        return result;
    }
}
