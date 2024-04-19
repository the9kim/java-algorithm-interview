package org.javaalgorithminterview.ch18_binary_search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class P75_1_Immigration {
    static class Time {
        int capacity;
        int spent = 0;

        public Time(int capacity) {
            this.capacity = capacity;
        }

    }

    public long solution(int n, int[] times) {
        Arrays.sort(times);
        int gap = times[times.length - 1] / times[0];

        Queue<Time> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.spent, o2.spent));
        for (int time : times) {
            pq.offer(new Time(time));
        }

        for (int i = 1; i < n - gap + 1; i++) {
            Time min = pq.poll();
            min.spent += min.capacity;
            pq.offer(min);
        }

        List<Time> timeLst = new ArrayList<>(pq);
        for (int i = 0; i < gap; i++) {
            for (int j = 0; j < pq.size(); j++) {
                Time time = timeLst.get(j);
                time.spent += time.capacity;
            }
        }

        return timeLst.stream()
                .mapToLong(e -> e.spent)
                .min()
                .getAsLong();
    }

//    public long solution(int n, int[] times) {
//        Arrays.sort(times);
//        int gap = times[times.length - 1] / times[0];
//
//        int[] spent = new int [times.length];
//        Arrays.fill(spent, 0);
//
//        for (int i = 1; i <= n - gap; i++) {
//
//            // Find the minimum value
//            int left = 0;
//            int right = spent.length - 1;
//            int min = -1;
//            while (left < right) {
//                int mid = left + (right - left) / 2;
//                if (spent[mid] > spent[right]) {
//                    left = mid + 1;
//                } else {
//                    right = mid;
//                }
//                min = left;
//            }
//
//            // Update the cumulated time to the minimum element
//            spent[min] += times[min];
//        }
//
//        for (int i = 0; i < gap; i++) {
//            for (int j = 0; j < times.length; j++) {
//                spent[j] += times[i];
//            }
//        }
//
//        return Arrays.stream(spent).min().getAsInt();
//    }
}
