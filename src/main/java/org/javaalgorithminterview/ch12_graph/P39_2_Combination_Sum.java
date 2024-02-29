package org.javaalgorithminterview.ch12_graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * The book solution
 *
 * The key aspect is to include an index as a parameter in the recursive method, which leads to the duplication of elements
 */
public class P39_2_Combination_Sum {

    public void dfs(List<List<Integer>> answer, int[] candidates, int target,
                    Deque<Integer> elements, int index) {

        if (target == 0) {
            answer.add(new ArrayList(elements));
            return;
        } else if (target < 0) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            elements.add(candidates[i]);
            dfs(answer, candidates, target - candidates[i], elements, i);
            elements.removeLast();
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> answer = new ArrayList<>();

        dfs(answer, candidates, target, new ArrayDeque<>(), 0);

        return answer;
    }
}
