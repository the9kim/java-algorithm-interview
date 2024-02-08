package org.javaalgorithminterview.ch10_deque_and_priority_queue;

public class P26_1_Design_Circular_Deque {

    int[] deque;
    int size;
    int front = 0;
    int rear;

    int length = 0;

    public P26_1_Design_Circular_Deque(int k) {
        this.deque = new int[k];
        this.size = k;
        this.rear = k - 1;
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        } else {
            front = (front - 1 + deque.length) % deque.length;
            deque[front] = value;
            length++;
            return true;
        }
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        } else {
            rear = (rear + 1) % deque.length;
            deque[rear] = value;
            length++;
            return true;
        }
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        } else {
            front = (front + 1 ) % deque.length;
            length--;
            return true;
        }
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        } else {
            rear = ((rear - 1) + deque.length) % deque.length;
            length--;
            return true;
        }
    }

    public int getFront() {
        return isEmpty() ? -1 : deque[front];
    }

    public int getRear() {
        return isEmpty() ? -1 : deque[rear];
    }

    public boolean isFull() {
        return length == deque.length;
    }

    public boolean isEmpty() {
        return length == 0;
    }

}
