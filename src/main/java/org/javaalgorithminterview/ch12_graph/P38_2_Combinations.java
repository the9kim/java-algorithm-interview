package org.javaalgorithminterview.ch12_graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class P38_2_Combinations {

    public void dfs(
            List<List<Integer>> answer,
            LinkedList<Integer> elements,
            int end,
            int start,
            int length
            ) {

        if (length == 0) {
            answer.add(elements.stream().collect(Collectors.toList()));
            return;
        }

        for (int i = start; i <= end; i++) {
            elements.add(i);
            dfs(answer, elements, end, i + 1, length - 1);
            elements.removeLast();
        }
    }

    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> answer = new ArrayList<>();

        dfs(answer, new LinkedList<>(), n, 1, k);

        return answer;
    }
}
