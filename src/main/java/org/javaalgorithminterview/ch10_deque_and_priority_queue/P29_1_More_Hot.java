package org.javaalgorithminterview.ch10_deque_and_priority_queue;

import java.util.PriorityQueue;

public class P29_1_More_Hot {

    /** PROGRAMMERS
     *
     * 1. Add all elements to the priority queue.
     * 2. Poll two elements and calculate the index and add it to the priority queue again
     * 3. if all elements satisfy the condition K, return the count number.
     */
    public int solution(int[] scoville, int K) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // 1
        for (int e : scoville) {
            pq.add(e);
        }

        // 2
        int count = 0;
        while (pq.size() >= 2 && pq.peek() < K) {
            int e1 = pq.poll();
            int e2 = pq.poll();

            int index = e1 + e2 * 2;
            count++;

            pq.add(index);
        }

        // 3
        return pq.peek() < K ? -1 : count;
    }
}
