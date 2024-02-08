package org.javaalgorithminterview.ch10_deque_and_priority_queue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class P28_1_K_Closest_Points_to_Origin {

    /**
     * 1. Set the PriorityQueue's Comparator.
     * 2. Add elements in the input array to the priority queue.
     * 3. Poll the Kth element and return it.
     */
    public int[][] kClosest(int[][] points, int k) {

        // 1
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                double distance1 = Math.sqrt(o1[0] * o1[0] + o1[1] * o1[1]);
                double distance2 = Math.sqrt(o2[0] * o2[0] + o2[1] * o2[1]);

                if (distance1 == distance2) {
                    return 0;
                } else if (distance1 > distance2) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });

        // 2
        for (int[] point : points) {
            pq.add(point);
        }

        // 3
        int[][] answer = new int[k][];

        for (int i = 0; i < k; i++) {
            answer[i] = pq.poll();
        }

        return answer;
    }
}
