package org.javaalgorithminterview.ch9_stack_and_queue;

import java.util.Deque;
import java.util.LinkedList;

public class P25_1_Design_Circular_Queue {

    Deque<Integer> q = new LinkedList<>();
    int size;

    public P25_1_Design_Circular_Queue(int k) {
        this.size = k;
    }

    public boolean enQueue(int value) {
        if (q.size() >= this.size) {
            return false;
        }
        q.add(value);
        return true;
    }

    public boolean deQueue() {
        if (q.isEmpty()) {
            return false;
        }
        q.remove();
        return true;
    }

    public int Front() {
        if (q.peek() == null) {
            return -1;
        }
        return q.peek();
    }

    public int Rear() {
        if (q.peek() == null) {
            return -1;
        }
        return q.peekLast();
    }

    public boolean isEmpty() {
        return q.size() == 0;
    }

    public boolean isFull() {
        return q.size() == this.size;
    }


}
