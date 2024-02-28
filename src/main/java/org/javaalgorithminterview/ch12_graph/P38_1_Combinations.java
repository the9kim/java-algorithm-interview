package org.javaalgorithminterview.ch12_graph;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class P38_1_Combinations {

    public void dfs(
            List<List<Integer>> answer,
            List<Integer> preElements,
            List<Integer> elements,
            int k) {

        if (preElements.size() == k) {
            answer.add(preElements.stream().collect(Collectors.toList()));
            return;
        }

        for (int i = 0; i < elements.size(); i++) {
            List<Integer> nextElements = elements.subList(i+1, elements.size());
            preElements.add(elements.get(i));
            dfs(answer, preElements, nextElements, k);
            preElements.remove(elements.get(i));
        }

    }

    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> answer = new ArrayList<>();

        List<Integer> elements = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            elements.add(i+1);
        }

        dfs(answer, new ArrayList<>(), elements, k);

        return answer;
    }

}
