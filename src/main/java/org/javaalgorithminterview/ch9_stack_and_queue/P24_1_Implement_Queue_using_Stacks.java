package org.javaalgorithminterview.ch9_stack_and_queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class P24_1_Implement_Queue_using_Stacks {

    Deque<Integer> queue = new ArrayDeque<>();

    public P24_1_Implement_Queue_using_Stacks(){
    }

    /**
     * 1. Order the deque like a stack
     * 2. Push the element
     * 3. Order the deque like a queue
     */
    public void push(int x) {
        Deque<Integer> temp = new ArrayDeque<>();

        // 1. Order deque like stack
        while (!queue.isEmpty()) {
            temp.push(queue.pop());
        }
        // 2. Push element
        temp.push(x);


        // 3. Order deque like queue
        while (!temp.isEmpty()) {
            queue.push(temp.pop());
        }
    }

    public int pop() {
        return queue.pop();
    }

    public int peek() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.size() == 0;
    }
}
