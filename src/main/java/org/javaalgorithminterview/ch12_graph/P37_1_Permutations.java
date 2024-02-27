package org.javaalgorithminterview.ch12_graph;

import java.util.List;
import java.util.ArrayList;

/**
 * The method to utilize iteration skipping the used element.
 */
public class P37_1_Permutations {

    public void dfs(
            int[] nums,
            List<List<Integer>> answer,
            List<Integer> unit
            ) {

        if (unit.size() == nums.length) {
            answer.add(unit);
            return;
        }

        for (int num : nums) {
            if (!unit.contains(num)) {
                List<Integer> newUnit = new ArrayList<>(unit);
                newUnit.add(num);
                dfs(nums, answer, newUnit);
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> unit = new ArrayList<>();

        dfs(nums, answer, unit);

        return answer;
    }




}
