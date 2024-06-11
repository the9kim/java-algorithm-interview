package org.kakao20;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class P2_1_Bracket_Transformation {
    /**
     * 1. Split the input string into U and V
     * 2. Check if the substring U is valid
     * 3. Combine results from recursive operations
     */
    public String solution(String p) {
        if (p.isEmpty()) {
            return "";
        }

        // 1.
        int idx = findSplitPoint(p);
        String left = p.substring(0, idx);
        String right = solution(p.substring(idx));

        StringBuilder sb = new StringBuilder();

        // 2.
        if (isValid(left)) {
            // 3.
            sb.append(left);
            sb.append(right);
            return sb.toString();
        } else {
            sb.append("(");
            sb.append(right);
            sb.append(")");
            sb.append(switchBracket(left.substring(1, left.length() - 1)));
            return sb.toString();
        }
    }

    public int findSplitPoint(String p) {
        int open = 0;
        int close = 0;

        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);

            if (c == '(') {
                open++;
            } else {
                close++;
            }

            if (open == close) {
                return open + close;
            }
        }
        return 0;
    }

    // This method causes Runtime error but I don't know why
//    public int findSplitPoint(String p) {
//        Map<Character, Integer> counter = new HashMap<>();
//        counter.put('(', 0);
//        counter.put(')', 0);
//
//        for (int i = 0; i < p.length(); i++) {
//            char c = p.charAt(i);
//            counter.put(c, counter.get(c) + 1);
//
//            if (counter.get('(') == counter.get(')')) {
//                return i + 1;
//            }
//        }
//        return -1;
//    }

    public boolean isValid(String p) {
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') {
                stack.push(p.charAt(i));
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }

//    public boolean isValid(String p) {
//        Map<Character, Integer> counter = new HashMap<>();
//
//        for (int i = 0; i < p.length(); i++) {
//            char c = p.charAt(i);
//
//            if (c == '(') {
//                counter.put('(', counter.getOrDefault('(', 0) + 1);
//            } else {
//                if (!counter.containsKey('(') || counter.get('(') == 0) {
//                    return false;
//                }
//                counter.put('(', counter.get('(') - 1);
//            }
//        }
//        return true;
//    }

    public String switchBracket(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                sb.append(')');
            } else {
                sb.append('(');
            }
        }
        return sb.toString();
    }

}
