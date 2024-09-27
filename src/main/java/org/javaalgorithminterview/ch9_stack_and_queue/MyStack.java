package org.javaalgorithminterview.ch9_stack_and_queue;

import org.assertj.core.internal.bytebuddy.implementation.bytecode.Throw;

public class MyStack {
    static class MyNode {
        int item;
        MyNode next;

        public MyNode(int item, MyNode next) {
            this.item = item;
            this.next = next;
        }
    }

    MyNode top;

    public MyStack() {
        this.top = null;
    }

    public void push(int item) {
        this.top = new MyNode(item, this.top);
    }

    public int poll() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is Empty");
        }
        int item = this.top.item;

        this.top = this.top.next;

        return item;
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return top.item;
    }

    public boolean isEmpty() {
        return this.top == null;
    }

}
