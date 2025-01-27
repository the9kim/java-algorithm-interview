package org.javaalgorithminterview.ch10_deque_and_priority_queue;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class P29_1_More_Hot {

    public int solution(int[] scoville, int K) {
        List<Integer> s = Arrays.stream(scoville).boxed().collect(Collectors.toList());
        PriorityQueue<Integer> pq = new PriorityQueue<>(s);

        int counter = 0;

        while (pq.size() >= 2 && pq.peek() < K) {
            int a = pq.poll();
            int b = pq.poll();
            pq.offer(a + b * 2);
            counter++;
        }

        if (pq.peek() < K) {
            return -1;
        }

        return counter;

    }
}
