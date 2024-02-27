package org.javaalgorithminterview.ch12_graph;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;


/**
 * The book solution
 *
 * The method to extract the used element first, then utilize iteration.
 */
public class P37_2_Permutations {

    public void dfs(
            List<List<Integer>> result,
            List<Integer> preElements,
            List<Integer> elements) {

        if (elements.isEmpty()) {
            result.add(preElements.stream().collect(Collectors.toList()));
        }

        for (Integer e : elements) {
            List<Integer> nextElements = new ArrayList<>(elements);
            nextElements.remove(e);
            preElements.add(e);

            dfs(result, preElements, nextElements);
            preElements.remove(e);
        }
    }
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        List<Integer> input = Arrays.stream(nums).boxed().collect(Collectors.toList());

        dfs(result, new ArrayList<>(), input);

        return result;
    }
}
