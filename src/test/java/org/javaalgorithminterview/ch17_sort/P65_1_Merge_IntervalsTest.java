package org.javaalgorithminterview.ch17_sort;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class P65_1_Merge_IntervalsTest {

    @Test
    void merge() {
        // given
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] expected = {{1, 6}, {8, 10}, {15, 18}};
        P65_1_Merge_Intervals p65 = new P65_1_Merge_Intervals();

        // when
        int[][] answer = p65.merge(intervals);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }

    @Test
    void sortArrays() {
        // given
        int[][] intervals = {{8, 10}, {2, 6}, {1, 3}, {15, 18}};

        int[][] expected = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};

        // when
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // then
        Assertions.assertThat(intervals).isEqualTo(expected);
    }

    @Test
    void containmentRelationship1() {
        // given
        int[][] intervals = {{1, 3}, {2, 6}};

        int[][] expected = {{1, 6}};

        // when
        List<List<Integer>> elems = new ArrayList<>();
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i][1] >= intervals[i + 1][0]
                    && intervals[i][1] < intervals[i + 1][1]) {
                elems.add(List.of(intervals[i][0], intervals[i + 1][1]));
            }
        }
        int[][] answer = convert(elems);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }

    @Test
    void containmentRelationship2() {
        // given
        int[][] intervals = {{1, 7}, {2, 6}};

        int[][] expected = {{1, 7}};

        // when
        List<List<Integer>> elems = new ArrayList<>();
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i][1] >= intervals[i + 1][1]) {
                elems.add(List.of(intervals[i][0], intervals[i][1]));
            }
        }
        int[][] answer = convert(elems);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }

    public int[][] convert(List<List<Integer>> elems) {
        int row = elems.size();
        int col = elems.get(0).size();

        int[][] answer = new int[row][col];

        for (int i = 0; i < row; i++) {
            List<Integer> inner = elems.get(i);
            for (int j = 0; j < col; j++) {
                answer[i][j] = inner.get(j);
            }
        }
        return answer;
    }
}
