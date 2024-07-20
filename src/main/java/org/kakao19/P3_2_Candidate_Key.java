package org.kakao19;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class P3_2_Candidate_Key {
    /**
     * Test-failed
     *
     * 1. Calculate subsets of columns
     * 2. Check minimality for candidate keys
     * 3. Check uniqueness for candidate keys
     */
    public int solution(String[][] relation) {
        // 1.
        List<Integer> set = new ArrayList<>();
        for (int i = 0; i < relation[0].length; i++) {
            set.add(i);
        }
        List<List<Integer>> subsets = new ArrayList<>();
        calSubsets(subsets, set, new ArrayList<>(), 0);


        int count = 0;
        List<String> used = new ArrayList<>();


        for (List<Integer> subset : subsets) {

            // 2.
            boolean isMinimal = true;
            String joinedSubset = subset.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining());

            for (String u : used) {
                if (joinedSubset.contains(u)) {
                    isMinimal = false;
                }
            }

            // 3.
            if (isMinimal) {
                Set<String> columns = new HashSet<>();
                for (String[] row : relation) {
                    StringBuilder sb = new StringBuilder();
                    for (Integer col : subset) {
                        sb.append(row[col]);
                    }
                    columns.add(sb.toString());
                }
                if (columns.size() == relation.length) {
                    count++;
                    used.add(joinedSubset);
                }
            }
        }
        return count;
    }

    public void calSubsets(List<List<Integer>> subsets, List<Integer> set, List<Integer> elems, int idx) {
        if (idx >= set.size()) {
            return;
        }

        subsets.add(new ArrayList<>(elems));

        for (int i = idx; i < set.size(); i++) {
            elems.add(i);
            calSubsets(subsets, set, elems, i + 1);
            elems.remove((Integer) i);
        }
    }
}
