package org.javaalgorithminterview.ch22_divide_and_conquer;

import java.util.ArrayList;
import java.util.List;

public class P90_1_Different_Ways_to_Add_Parentheses {

    /**
     * The book solution
     */

    public List<Integer> diffWaysToCompute(String expression) {

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i + 1));

                for (Integer l : left) {
                    for (Integer r : right) {
                        if (c == '+') {
                            result.add(l + r);
                        } else if (c == '-') {
                            result.add(l - r);
                        } else if (c == '*') {
                            result.add(l * r);
                        }
                    }
                }
            }
        }

        if (result.isEmpty()) {
            result.add(Integer.valueOf(expression));
        }

        return result;
    }
}
