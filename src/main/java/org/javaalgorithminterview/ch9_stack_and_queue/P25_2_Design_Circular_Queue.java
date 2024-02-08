package org.javaalgorithminterview.ch9_stack_and_queue;


/**
 * The solution the book suggests
 */
public class P25_2_Design_Circular_Queue {

    int[] q;

    // Distance between front and rear
    int len = 0;
    int front = 0;
    int rear = -1;

    P25_2_Design_Circular_Queue(int k) {
        q = new int[k];
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        rear = (rear + 1) % q.length;
        q[rear] = value;
        len++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        front = (front + 1) % q.length;
        len--;
        return true;
    }

    public int Front() {
        return this.isEmpty() ? -1 : q[front];
    }

    public int Rear() {
        return this.isEmpty() ? -1 : q[rear];
    }

    public boolean isEmpty() {
        return len == 0;
    }

    public boolean isFull() {
        return len == q.length;
    }
}
