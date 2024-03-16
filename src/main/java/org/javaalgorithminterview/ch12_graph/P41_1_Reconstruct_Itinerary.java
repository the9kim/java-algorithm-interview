package org.javaalgorithminterview.ch12_graph;

import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.Deque;
import java.util.ArrayDeque;

/**
 * The method using iteration
 *
 * 1. Create a Graph using the input list
 * 2. Find a route using a stack
 */
public class P41_1_Reconstruct_Itinerary {

    public List<String> findItinerary(List<List<String>> tickets) {

        // 1
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for (List<String> ticket : tickets) {
            graph.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            graph.get(ticket.get(0)).add(ticket.get(1));
        }

        // 2
        List<String> route = new LinkedList<>();
        Deque<String> stack = new ArrayDeque<>();
        stack.push("JFK");

        // Continue searching until all paths are found.
        while (!stack.isEmpty()) {
            // Continue searching until one disconnected path has been found
            while (graph.containsKey(stack.peek()) && !graph.get(stack.peek()).isEmpty()) {
                String top = graph.get(stack.peek()).poll();
                stack.push(top);
            }
            // Add the disconnected path to the end of the final path
            route.add(0, stack.pop());
        }

        return route;
    }

}
