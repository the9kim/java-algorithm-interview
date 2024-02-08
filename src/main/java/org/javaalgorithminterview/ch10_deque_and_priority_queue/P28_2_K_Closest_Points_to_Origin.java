package org.javaalgorithminterview.ch10_deque_and_priority_queue;

import java.util.PriorityQueue;
import java.util.Comparator;


public class P28_2_K_Closest_Points_to_Origin {
    public static class Point {
        int[] point;
        double distance;

        public Point(int[] point, double distance) {
            this.point = point;
            this.distance = distance;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> pq = new PriorityQueue<>(Comparator.comparingDouble(point -> point.distance));

        for (int[] point : points) {
            double distance = Math.sqrt(Math.pow(point[0], 2) + Math.pow(point[1], 2));
            pq.add(new Point(point, distance));
        }

        int[][] answer = new int[k][];
        for (int i = 0; i < k; i++) {
            answer[i] = pq.poll().point;
        }

        return answer;
    }
}
