package org.javaalgorithminterview.ch10_deque_and_priority_queue;

public class P26_2_Design_Circular_Deque {

    private static class DoublyLinkedList {
        private DoublyLinkedList left;
        private DoublyLinkedList right;
        int value;

        public DoublyLinkedList(int value) {
            this.value = value;
        }
    }

    private DoublyLinkedList head;
    private DoublyLinkedList tail;

    int len;
    int size;

    public P26_2_Design_Circular_Deque(int k) {
        head = new DoublyLinkedList(0);
        tail = new DoublyLinkedList(0);
        this.size = k;
        this.len = 0;

        // Connect the head and tail
        head.right = tail;
        tail.left = head;
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        } else {
            DoublyLinkedList node = new DoublyLinkedList(value);

            // Insert the new node directly to the right of the head
            node.left = head;
            node.right = head.right;
            head.right.left = node;
            head.right = node;

            len++;
            return true;
        }
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        } else {
            DoublyLinkedList node = new DoublyLinkedList(value);

            // Insert the new node directly to the left of tail
            node.left = tail.left;
            node.right = tail;
            tail.left.right = node;
            tail.left = node;

            len++;
            return true;
        }
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        } else {

            // Disconnect the node at the right side of the head
            head.right.right.left = head;
            head.right = head.right.right;

            len--;

            return true;
        }
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        } else {

            // Disconnect the node at the left side of the tail
            tail.left.left.right = tail;
            tail.left = tail.left.left;

            len--;

            return true;
        }
    }

    public int getFront() {
        return isEmpty() ? -1 : head.right.value;
    }

    public int getRear() {
        return isEmpty() ? -1 : tail.left.value;
    }

    public boolean isEmpty() {
        return this.len == 0;
    }

    public boolean isFull() {
        return this.len == this.size;
    }
}
