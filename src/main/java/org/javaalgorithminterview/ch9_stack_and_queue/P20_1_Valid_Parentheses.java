package org.javaalgorithminterview.ch9_stack_and_queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class P20_1_Valid_Parentheses {

    /**
     * A solution the book suggests
     * using a tale for checking validation
     */
    public boolean isValid(String s) {

        Map<Character, Character> table = new HashMap<>();
        table.put(')', '(');
        table.put(']', '[');
        table.put('}', '{');

        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            if (!table.containsKey(s.charAt(i))) {
                stack.push(s.charAt(i));
            } else {
                if (stack.isEmpty()
                        || stack.pop() != table.get(s.charAt(i))) {
                    return false;
                }
            }
        }

        return stack.size() == 0;
    }

    /**
     * 1. Utilize iteration
     * 2. If an element is '(' or '[' or '{', Push it onto the stack
     * 3. If an element is ')' or ']' or '}', compare it with the top of the stack.
     */
    public boolean isValid2(String s) {

        Deque<String> stack = new ArrayDeque<>();

        String[] parentheses = s.split("");

        for (String p : parentheses) {
            if (p.equals("(")
                    || p.equals("[")
                    || p.equals("{")) {
                stack.push(p);
            } else {

                // check if there is an opening parentheses
                if (stack.isEmpty()) {
                    return false;
                }
                String top = stack.pop();

                if (p.equals(")")) {
                    if (!top.equals("(")) {
                        return false;
                    }
                } else if (p.equals("]")) {
                    if (!top.equals("[")) {
                        return false;
                    }
                } else {
                    if (!top.equals("{")) {
                        return false;
                    }
                }
            }
        }

        // check if there is a closing parenthesis
        if (!stack.isEmpty()) {
            return false;
        }

        return true;
    }


}
