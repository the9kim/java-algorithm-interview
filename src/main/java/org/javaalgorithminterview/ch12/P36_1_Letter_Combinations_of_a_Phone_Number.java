package org.javaalgorithminterview.ch12;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P36_1_Letter_Combinations_of_a_Phone_Number {

    public void dfs(
            List<String> answer,
            Map<Character, List<Character>> graph,
            StringBuilder path,
            int index,
            String digits) {

        if (path.length() == digits.length()) {
            answer.add(String.valueOf(path));
            return;
        }

        for (Character c : graph.get(digits.charAt(index))) {
            dfs(answer, graph, new StringBuilder(path).append(c), index + 1, digits);
        }
    }

    public List<String> letterCombinations(String digits) {
        List<String> answer = new ArrayList<>();

        if (digits.length() == 0) {
            return answer;
        }

        Map<Character, List<Character>> graph = new HashMap<>();
        graph.put('2', new ArrayList<>(List.of('a', 'b', 'c')));
        graph.put('3', new ArrayList<>(List.of('d', 'e', 'f')));
        graph.put('4', new ArrayList<>(List.of('g', 'h', 'i')));
        graph.put('5', new ArrayList<>(List.of('j', 'k', 'l')));
        graph.put('6', new ArrayList<>(List.of('m', 'n', 'o')));
        graph.put('7', new ArrayList<>(List.of('p', 'q', 'r', 's')));
        graph.put('8', new ArrayList<>(List.of('t', 'u', 'v')));
        graph.put('9', new ArrayList<>(List.of('w', 'x', 'y', 'z')));

        StringBuilder path = new StringBuilder();

        dfs(answer, graph, path, 0, digits);

        return answer;
    }

    public List<String> letterCombinations2(String digits) {
        if (digits.isEmpty()) {
            return new ArrayList<>();
        }

        // 1
        Map<Character, List<Character>> graph = new HashMap<>();
        graph.put('2', new ArrayList<>(List.of('a', 'b', 'c')));
        graph.put('3', new ArrayList<>(List.of('d', 'e', 'f')));
        graph.put('4', new ArrayList<>(List.of('g', 'h', 'i')));
        graph.put('5', new ArrayList<>(List.of('j', 'k', 'l')));
        graph.put('6', new ArrayList<>(List.of('m', 'n', 'o')));
        graph.put('7', new ArrayList<>(List.of('p', 'q', 'r', 's')));
        graph.put('8', new ArrayList<>(List.of('t', 'u', 'v')));
        graph.put('9', new ArrayList<>(List.of('w', 'x', 'y', 'z')));


        // 2
        Map<Character, List<Character>> innerGraph = new HashMap<>();

        if (digits.length() == 1) {
            innerGraph.put('0', graph.get(digits.charAt(0)));
        }

        for (int i = 0; i < digits.length() - 1; i++) {
            for (char c : graph.get(digits.charAt(i))) {
                innerGraph.put(c, new ArrayList<>(graph.get(digits.charAt(i + 1))));

                if (i == 0) {
                    innerGraph.putIfAbsent('0', new ArrayList<>());
                    innerGraph.get('0').add(c);
                }
            }
        }

        // 3
        List<String> answer = new ArrayList<>();
        Deque<Character> stack = new ArrayDeque<>();
        stack.push('0');

        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {
            Character top = stack.pop();

            while (sb.length() > 0
                    && innerGraph.containsKey(top)
                    && sb.charAt(sb.length() - 1) > top) {
                sb.deleteCharAt(sb.length() - 1);
            }

            sb.append(top);

            if (innerGraph.containsKey(top)) {
                for (Character c : innerGraph.get(top)) {
                    stack.push(c);
                }
            }

            if (sb.length() == digits.length() + 1) {
                answer.add(sb.toString().substring(1));
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return answer;
    }


    public List<String> letterCombinations3(String digits) {
        if (digits.isEmpty()) {
            return new ArrayList<>();
        }

        // 1
        Map<Character, List<Character>> graph = new HashMap<>();
        graph.put('2', new ArrayList<>(List.of('a', 'b', 'c')));
        graph.put('3', new ArrayList<>(List.of('d', 'e', 'f')));
        graph.put('4', new ArrayList<>(List.of('g', 'h', 'i')));
        graph.put('5', new ArrayList<>(List.of('j', 'k', 'l')));
        graph.put('6', new ArrayList<>(List.of('m', 'n', 'o')));
        graph.put('7', new ArrayList<>(List.of('p', 'q', 'r', 's')));
        graph.put('8', new ArrayList<>(List.of('t', 'u', 'v')));
        graph.put('9', new ArrayList<>(List.of('w', 'x', 'y', 'z')));

        // 2
        Map<Character, List<Character>> innerGraph = new HashMap<>();

        if (digits.length() == 1) {
            innerGraph.put('0', graph.get(digits.charAt(0)));
        }

        for (int i = 0; i < digits.length() - 1; i++) {
            while (graph.containsKey(digits.charAt(i))
                    && !graph.get(digits.charAt(i)).isEmpty()) {

                Character key = graph.get(digits.charAt(i)).remove(0);
                innerGraph.put(
                        key,
                        new ArrayList<>(graph.get(digits.charAt(i + 1))));

                innerGraph.putIfAbsent('0', new ArrayList<>());
                innerGraph.get('0').add(key);
            }
        }

        // 3
        List<String> answer = new ArrayList<>();
        Deque<Character> stack = new ArrayDeque<>();
        stack.push('0');

        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {
            while (innerGraph.containsKey(stack.peek()) &&
                    !innerGraph.get(stack.peek()).isEmpty()) {
                Character value = innerGraph.get(stack.peek()).remove(0);
                stack.push(value);
                sb.append(value);
            }
            if (sb.length() == digits.length()) {
                answer.add(sb.toString());
            }
            stack.pop();
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
        }

        return answer;
    }
}
