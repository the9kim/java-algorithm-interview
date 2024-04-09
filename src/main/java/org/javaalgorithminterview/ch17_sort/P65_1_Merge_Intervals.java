package org.javaalgorithminterview.ch17_sort;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class P65_1_Merge_Intervals {

    /**
     * 1. Sort Arrays based on the values of their leftmost elements
     * 2. Check for containment relationships
     */
    public int[][] merge(int[][] intervals) {
        // 1
        Arrays.sort(intervals, (o1, o2) -> Integer.compare(o1[0], o2[0]));

        // 2
        Deque<int[]> stack = new ArrayDeque<>();
        stack.push(new int[]{intervals[0][0], intervals[0][1]});

        for (int i = 1; i < intervals.length; i++) {
            int[] top = stack.peek();
            int[] cur = intervals[i];

            if (top[1] >= cur[0] && top[1] < cur[1]) {
                stack.pop();
                stack.push(new int[]{top[0], cur[1]});
            } else if (top[1] >= cur[1] || (top[0] == cur[0] && top[1] == cur[1])) {
                continue;
            } else {
                stack.push(new int[]{cur[0], cur[1]});
            }
        }

        // 3
        int row = stack.size();
        int col = stack.peek().length;
        int[][] answer = new int[row][col];

        while (!stack.isEmpty()) {
            answer[stack.size() - 1] = stack.pop();
        }
        return answer;
    }
}
