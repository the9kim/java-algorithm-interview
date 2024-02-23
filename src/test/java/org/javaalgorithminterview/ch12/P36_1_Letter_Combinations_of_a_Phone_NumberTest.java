package org.javaalgorithminterview.ch12;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class P36_1_Letter_Combinations_of_a_Phone_NumberTest {

    @Test
    void create_Inner_Graph() {
        // given
        Map<Character, List<Character>> graph = new HashMap<>();
        graph.put('2', new ArrayList<>(List.of('a', 'b', 'c')));
        graph.put('3', new ArrayList<>(List.of('d', 'e', 'f')));
        graph.put('4', new ArrayList<>(List.of('g', 'h', 'i')));
        graph.put('5', new ArrayList<>(List.of('j', 'k', 'l')));
        graph.put('6', new ArrayList<>(List.of('m', 'n', 'o')));
        graph.put('7', new ArrayList<>(List.of('p', 'q', 'r', 's')));
        graph.put('8', new ArrayList<>(List.of('t', 'u', 'v')));
        graph.put('9', new ArrayList<>(List.of('w', 'x', 'y', 'z')));

        String digits = "22";
        // when
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

        // then
        System.out.println(innerGraph);
    }

    @Test
    void find_Route2() {
        // given
        Map<Character, List<Character>> graph = new HashMap<>();
        graph.put('2', new ArrayList<>(List.of('a', 'b', 'c')));
        graph.put('3', new ArrayList<>(List.of('d', 'e', 'f')));
        graph.put('4', new ArrayList<>(List.of('g', 'h', 'i')));
        graph.put('5', new ArrayList<>(List.of('j', 'k', 'l')));
        graph.put('6', new ArrayList<>(List.of('m', 'n', 'o')));
        graph.put('7', new ArrayList<>(List.of('p', 'q', 'r', 's')));
        graph.put('8', new ArrayList<>(List.of('t', 'u', 'v')));
        graph.put('9', new ArrayList<>(List.of('w', 'x', 'y', 'z')));

        String digits = "22";
        // when
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

        List<String> answer = new ArrayList<>();
        Deque<Character> stack = new ArrayDeque<>();
        stack.push('0');

        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {
            Character top = stack.pop();

//            if (sb.length() > 0
//                    && innerGraph.containsKey(top)
//                    && sb.charAt(sb.length() - 1) == top + 1) {
//                sb.deleteCharAt(sb.length() - 1);
//            }
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

//                if (sb.length() > 0 && top != '0'
//                        && !innerGraph.get(sb.charAt(sb.length() - 1)).contains((char) (top - 1))) {
//                    sb.deleteCharAt(sb.length() - 1);
//                }
            }

//            if (top + 1 == sb.charAt(sb.length() - 1)) {
//                sb.deleteCharAt(sb.length() - 1);
//            }


        }

        // then
        System.out.println(answer);
    }

    @Test
    void find_Route() {
        // given
        Map<Character, List<Character>> graph = new HashMap<>();
        graph.put('2', new ArrayList<>(List.of('a', 'b', 'c')));
        graph.put('3', new ArrayList<>(List.of('d', 'e', 'f')));
        graph.put('4', new ArrayList<>(List.of('g', 'h', 'i')));
        graph.put('5', new ArrayList<>(List.of('j', 'k', 'l')));
        graph.put('6', new ArrayList<>(List.of('m', 'n', 'o')));
        graph.put('7', new ArrayList<>(List.of('p', 'q', 'r', 's')));
        graph.put('8', new ArrayList<>(List.of('t', 'u', 'v')));
        graph.put('9', new ArrayList<>(List.of('w', 'x', 'y', 'z')));

        String digits = "234";
        // when
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

                if (i == 0) {
                    innerGraph.putIfAbsent('0', new ArrayList<>());
                    innerGraph.get('0').add(key);
                }
            }
        }

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

        // then
        System.out.println(answer);
    }

}
