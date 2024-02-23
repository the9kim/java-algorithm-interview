package org.javaalgorithminterview.ch12;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Deque;
import java.util.ArrayDeque;
public class P42_1_Travel_Route_43164 {

    /**
     * The book solution
     */
    public String[] solution(String[][] tickets) {
        // 1
        Map<String, PriorityQueue<String>> graph = new HashMap<>();

        for (String[] ticket : tickets) {
            graph.putIfAbsent(ticket[0], new PriorityQueue<>());
            graph.get(ticket[0]).add(ticket[1]);
        }

        // 2.
        List<String> route = new LinkedList<>();
        Deque<String> stack = new ArrayDeque<>();

        stack.push("ICN");

        while (!stack.isEmpty()) {

            while (graph.containsKey(stack.getFirst())
                    && !graph.get(stack.getFirst()).isEmpty()) {
                stack.push(graph.get(stack.getFirst()).poll());
            }

            route.add(0, stack.pop());
        }


        return route.toArray(new String[0]);
    }

    /**
     * 1. Create a graph(String : PriorityQueue).
     * 2. Search the graph using DFS.
     */
    public String[] solution2(String[][] tickets) {
        // 1
        Map<String, PriorityQueue<String>> graph = new HashMap<>();

        for (String[] ticket : tickets) {
            PriorityQueue<String> value = graph.getOrDefault(ticket[0], new PriorityQueue<>(Comparator.reverseOrder()));
            value.add(ticket[1]);
            graph.put(ticket[0], graph.getOrDefault(ticket, value));
        }

        // 2.
        List<String> route = new ArrayList<>();
        Deque<String> stack = new ArrayDeque<>();

        stack.push("ICN");

        while (!stack.isEmpty()) {
            String node = stack.pop();
            route.add(node);

            PriorityQueue<String> pq = graph.get(node);
            while (pq != null && !pq.isEmpty()) {
                String temp = pq.poll();
                stack.push(temp);
            }
        }

        return route.toArray(new String[0]);
    }
}
