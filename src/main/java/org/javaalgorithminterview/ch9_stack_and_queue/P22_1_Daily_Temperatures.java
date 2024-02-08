package org.javaalgorithminterview.ch9_stack_and_queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class P22_1_Daily_Temperatures {

    /**
     * 1. Utilize iteration and put each element onto a stack
     * 2. Compare each element with the top value of the stack
     * 3. Calculate the distance of the element and the stack value
     */
    public int[] dailyTemperatures(int[] temperatures) {

        int[] answer = new int[temperatures.length];

        Deque<Integer> stack = new ArrayDeque<>();

        // 1
        for (int i = 0; i < temperatures.length; i++) {

            // 2
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int top = stack.pop();

                // 3
                answer[top] = i - top;
            }

            stack.push(i);
        }
        return answer;
    }

}
