package org.javaalgorithminterview.ch9_stack_and_queue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class P21_1_Remove_Duplicate_Letters {

    /**
     * The solution the book suggests
     *
     * 1. Decrease the Counters' value by 1.
     * 2. Verify if the element has already been processed.
     * 3. Check if the count of the top element in the stack is greater than 0.
     * and compare lexicographical order between the current element and the top element of the stack
     * 4. Push the current element onto the stack and make verifier status true.
     */
    public String removeDuplicateLetters4(String s) {

        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Integer> counter = new HashMap<>();
        Map<Character, Boolean> verifier = new HashMap<>();

        for (char c : s.toCharArray()) {
            counter.put(c, counter.get(c) == null ? 1 : counter.get(c) + 1);
        }

        for (char val : s.toCharArray()) {

            // 1
            counter.put(val, counter.get(val) - 1);

            // 2
            if (verifier.get(val) != null && verifier.get(val) == true) {
                continue;
            }

            // 3
            while (!stack.isEmpty() && stack.peek() > val && counter.get(stack.peek()) > 0) {

                Character top = stack.pop();
                verifier.put(top, false);

            }

            // 4
            stack.push(val);

            verifier.put(val, true);
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pollLast());
        }

        return sb.toString();
    }

    /**
     * With this code, I can deal with the input value "bcabc"
     */
    public String removeDuplicateLetters(String s) {
        List<Character> answer = new ArrayList<>();


        for (int i = 0; i < s.length(); i++) {
            // 1. validate duplication
            if (answer.contains(s.charAt(i))) {

                // 2. compare lexicographical order
                int idx = answer.indexOf(s.charAt(i));
                if (idx < answer.size() - 1 && answer.get(idx) > answer.get(idx + 1)) {
                    answer.remove(idx);
                    answer.add(s.charAt(i));
                }
            } else {
                answer.add(s.charAt(i));
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Character c : answer) {
            sb.append(c);
        }
        return sb.toString();
    }

    /**
     * I try to find out all cases, sort them, and return the first case.
     * But with this code, I couldn't deal with all the cases.
     */
    public String removeDuplicateLetters2(String s) {
        Set<List<Character>> total = new HashSet<>();
        int maxLen = 0;
        List<Character> answer = new ArrayList<>();


        for (int i = 0; i < s.length(); i++) {
            // 1. validate duplication
            if (answer.contains(s.charAt(i))) {
                total.add(new ArrayList<>(answer));
                maxLen = Math.max(maxLen, answer.size());

                // 2. Don't compare lexicographical order
                int idx = answer.indexOf(s.charAt(i));
                if (idx < answer.size() - 1) {
                    answer.remove(idx);
                    answer.add(s.charAt(i));
                }

                total.add(new ArrayList<>(answer));
                maxLen = Math.max(maxLen, answer.size());
            } else {
                answer.add(s.charAt(i));
            }
        }

        System.out.println(total);

        List<String> collect = total.stream()
                .map(list -> list.stream()
                        .map(Object::toString)
                        .collect(Collectors.joining()))
                .sorted((list1, list2) -> list1.compareTo(list2))
                .collect(Collectors.toList());

        System.out.println(collect);
        return collect.get(0);
    }

    public String removeDuplicateLetters3(String s) {
        List<Character> q = new ArrayList<>();
        String str2 = "{";
        for (int i = 0; i < s.length(); i++) {
            if (q.contains(s.charAt(i))) {

                List<Character> temp = new ArrayList<>(q);
                temp.remove(new Character(s.charAt(i)));
                String front = temp.stream().map(Object::toString).collect(Collectors.joining());
                String tempStr = removeDuplicateLetters3(front + s.substring(i));
                str2 = compareLexicographicalOrder(tempStr, str2);
            } else {
                q.add(s.charAt(i));
            }
        }

        String str1 = q.stream()
                .map(Object::toString)
                .collect(Collectors.joining());


        return compareLexicographicalOrder(str1, str2);
    }


    public String compareLexicographicalOrder(String str1, String str2) {
        int minLength = Math.min(str1.length(), str2.length());

        for (int i = 0; i < minLength; i++) {
            if (str1.charAt(i) < str2.charAt(i)) {
                return str1;
            } else if (str1.charAt(i) > str2.charAt(i)) {
                return str2;
            }
        }

        return str1;
    }

}
