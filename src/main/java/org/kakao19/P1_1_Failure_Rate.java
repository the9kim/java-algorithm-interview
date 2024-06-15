package org.kakao19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class P1_1_Failure_Rate {
    /**
     * 1. Calculate failure rates
     * 2. Sort the failure rates in Descending order using Priority Queue
     */
    public int[] solution(int N, int[] stages) {

        // Covert the input array to a List
        List<Integer> stageList = Arrays.stream(stages)
                .boxed()
                .collect(Collectors.toList());

        // 2.
        PriorityQueue<double[]> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1[1] == o2[1]) {
                return Double.compare(o1[0], o2[0]);
            } else if (o1[1] > o2[1]) {
                return -1;
            } else {
                return 1;
            }
        });

        int restUser = stages.length;

        // 1.
        for (int i = 1; i <= N; i++) {
            Integer stage = i;
            int count = (int) stageList.stream()
                    .filter(e -> e.equals(stage))
                    .count();

            if (restUser == 0) {
                pq.add(new double[]{stage, 0});
                continue;
            }

            double failureRate = count / (double) restUser;
            pq.add(new double[]{stage, failureRate});

            restUser -= count;
        }

        // Convert an return the answer
        List<Integer> answer = new ArrayList<>();
        while (!pq.isEmpty()) {
            answer.add((int) pq.poll()[0]);
        }

        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
