package org.javaalgorithminterview.ch9_stack_and_queue;

import java.util.LinkedList;
import java.util.Queue;

public class P23_1_Implement_Stack_using_Queues {

    Queue<Integer> stack = new LinkedList<>();

    public P23_1_Implement_Stack_using_Queues() {
    }

    public void push(int x) {
        stack.add(x);

        for (int i = 0; i < stack.size() - 1; i++) {
            stack.add(stack.remove());
        }
    }

    public int pop() {
        return stack.remove();
    }

    public int top() {
        return stack.peek();
    }

    public boolean empty() {
        return stack.size() == 0;
    }
}
