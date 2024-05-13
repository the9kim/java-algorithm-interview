package org.javaalgorithminterview.ch21_greedy_algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class P85_1_Queue_Reconstruction_by_Height {
    static class ListNode {
        int height;
        int kth;
        int count;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int height, int kth) {
            this.height = height;
            this.kth = kth;
            this.count = kth;
        }
    }

    /**
     * The book solution using Priority Queue
     */

    public int[][] reconstructQueue(int[][] people) {

        // 1.
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (p1, p2) -> p1[0] != p2[0] ? p2[0] - p1[0] : p1[1] - p2[1]);

        for (int[] p : people) {
            pq.add(p);
        }


        // 2.
        List<int[]> answer = new ArrayList<>();

        while (!pq.isEmpty()) {
            int[] person = pq.poll();
            answer.add(person[1], person);
        }

        // 3.
        return answer.toArray(new int[answer.size()][2]);
    }
}
