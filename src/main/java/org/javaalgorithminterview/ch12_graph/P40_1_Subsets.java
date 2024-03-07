package org.javaalgorithminterview.ch12_graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class P40_1_Subsets {

    public void dfs(List<List<Integer>> answer, int[] nums, Deque<Integer> elements, int index) {
        answer.add(new ArrayList<>(elements));

        for (int i = index; i < nums.length; i++) {
            elements.add(nums[i]);
            dfs(answer, nums, elements, i + 1);
            elements.removeLast();
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();

        dfs(answer, nums, new ArrayDeque<>(), 0);

        return answer;
    }

}
