package org.javaalgorithminterview.ch9_stack_and_queue;

public class MyQueue {

    static class MyNode {
        int item;
        MyNode next;

        public MyNode(int item, MyNode next) {
            this.item = item;
            this.next = next;
        }
    }

    MyNode first;
    MyNode last;

    public MyQueue() {
        this.first = null;
        this.last = null;
    }

    public void offer(int item) {
        MyNode newNode = new MyNode(item, null);

        if (last != null) {
            last.next = newNode;
        }

        last = newNode;

        if (first == null) {
            first = last;
        }
    }

    public int poll() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        int item = first.item;

        first = first.next;

        return item;
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        return first.item;
    }

    public boolean isEmpty() {
        return first == null;
    }
}
