package org.javaalgorithminterview.ch12_graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * When a node has multiple prerequisites, this solution can only handle the first prerequisite.
 */
public class P43_1_Course_Schedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // 1
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int[] prerequisite : prerequisites) {
            graph.putIfAbsent(prerequisite[0], new ArrayList<>());
            graph.get(prerequisite[0]).add(prerequisite[1]);
        }


        for (int i = 0; i < numCourses; i++) {
            Deque<Integer> stack = new ArrayDeque<>();
            stack.push(i);
            while (graph.containsKey(stack.peek()) && !graph.get(stack.peek()).isEmpty()) {
                Integer prerequisite = graph.get(stack.peek()).remove(0);
                if (stack.contains(prerequisite)) {
                    return false;
                }
                stack.push(prerequisite);
            }
        }
        return true;
    }


    /**
     * 1. Create a graph.
     * 2. Check if prerequisites of a class have the class as a prerequisite.
     */
    public boolean canFinish2(int numCourses, int[][] prerequisites) {

        // 1
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int[] prerequisite : prerequisites) {
            graph.putIfAbsent(prerequisite[0], new ArrayList<>());
            graph.get(prerequisite[0]).add(prerequisite[1]);
        }




        // 2
        boolean containsAll = true;
        for (int i = 0; i < numCourses; i++) {
            if (graph.containsKey(i)) {
                continue;
            }
            containsAll = false;
        }
        if (containsAll == true) {
            return false;
        }

        for (int i = 0; i < numCourses; i++) {
            while (graph.containsKey(i) && !graph.get(i).isEmpty()) {
                Integer prerequisite = graph.get(i).remove(0);
                if (graph.containsKey(prerequisite) && graph.get(prerequisite).contains(i)
                        || i == prerequisite) {
                    return false;
                }
            }
        }
        return true;
    }
}
