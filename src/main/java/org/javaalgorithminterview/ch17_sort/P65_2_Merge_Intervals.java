package org.javaalgorithminterview.ch17_sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P65_2_Merge_Intervals {

    /**
     * The book solution
     * It simplifies the logic to verify containment relationship between two arrays
     * It convert a List type to an Array easily using the toArray method
     */
    public int[][] merge(int[][] intervals) {
        List<int[]> answer = new ArrayList<>();

        Arrays.sort(intervals, (o1, o2) -> Integer.compare(o1[0], o2[0]));

        for (int[] i : intervals) {
            int[] last = null;
            if (!answer.isEmpty()) {
                last = answer.get(answer.size() - 1);
            }
            if (last != null && i[0] <= last[1]) {
                last[1] = Math.max(last[1], i[1]);
            } else {
                answer.add(i);
            }
        }

        return answer.toArray(new int[answer.size()][]);
    }
}
