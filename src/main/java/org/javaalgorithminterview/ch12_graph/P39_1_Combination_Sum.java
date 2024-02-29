package org.javaalgorithminterview.ch12_graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class P39_1_Combination_Sum {

    public void dfs(
            Set<List<Integer>> answer,
            int[] candidates,
            int target,
            List<Integer> elements) {


        int sum = elements.stream().mapToInt(Integer::intValue).sum();
        if (sum == target) {
            answer.add(elements.stream().sorted().collect(Collectors.toList()));
            return;
        } else if (sum > target) {
            return;
        }

        for (Integer n : candidates) {
            elements.add(n);
            dfs(answer, candidates, target, elements);
            elements.remove(n);
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        Set<List<Integer>> answer = new HashSet<>();

        dfs(answer, candidates, target, new ArrayList<>());

        return answer.stream()
                .collect(Collectors.toList());
    }
}
