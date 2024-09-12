package org.kakao20;

import java.util.ArrayDeque;
import java.util.Deque;

public class P2_2_Bracket_Transformation {
    public String solution(String p) {
        if (p.equals("")) {
            return "";
        }

        String[] brackets = splitIntoBalancedBracket(p);

        StringBuilder sb = new StringBuilder();

        if (isValid(brackets[0])) {
            sb.append(brackets[0]);
            sb.append(solution(brackets[1]));
        } else {
            sb.append("(");
            sb.append(solution(brackets[1]));
            sb.append(")");

            sb.append(switchBrackets(brackets[0].substring(1, brackets[0].length() - 1)));
        }

        return sb.toString();
    }

    private String[] splitIntoBalancedBracket(String p) {
        int open = 0;
        int closed = 0;

        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);

            if (c == '(') {
                open++;
            } else if (c == ')') {
                closed++;
            }

            if (open != 0 && closed != 0 && open == closed) {
                return new String[]{p.substring(0, i + 1), p.substring(i + 1)};
            }
        }

        return new String[]{"", ""};
    }

    private boolean isValid(String bracket) {

        Deque<Character> stack = new ArrayDeque<>();

        for (char b : bracket.toCharArray()) {
            if (b == '(') {
                stack.push(b);
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

    private String switchBrackets(String brackets) {
        StringBuilder switched = new StringBuilder();

        for (char c : brackets.toCharArray()) {
            if (c == '(') {
                switched.append(')');
            } else {
                switched.append('(');
            }
        }

        return switched.toString();
    }

}
