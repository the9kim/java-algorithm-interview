package org.kakao19;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class P3_1_Candidate_Key {
    public int solution(String[][] relation) {

        // 1. Calculate subsets of each row
        List<List<List<String>>> totalSubsets = new ArrayList<>();
        for (String[] r : relation) {
            List<List<String>> subsets = new ArrayList<>();
            subsets(subsets, new StringBuilder(), new StringBuilder(), r, 0);
            totalSubsets.add(subsets);
        }


        // 2. Create a Hash map containing colum elements as values
        Map<String, Set<String>> colMap = new LinkedHashMap<>();
        for (List<List<String>> subsets : totalSubsets) {
            for (List<String> elem : subsets) {
                String key = elem.get(0);
                String value = elem.get(1);
                colMap.putIfAbsent(key, new HashSet<>());
                colMap.get(key).add(value);
            }
        }

        // 3. Calculate the number of Candidate Key
        List<String> candidateKeys = new ArrayList<>();
        for (Map.Entry<String, Set<String>> entry : colMap.entrySet()) {
            boolean isCandidate = true;
            String key = entry.getKey();
            Set<String> value = entry.getValue();

            for (String c : candidateKeys) {
                if (key.contains(c)) {
                    isCandidate = false;
                    break;
                }
            }
            if (isCandidate
                    && value.size() == relation.length) {
                candidateKeys.add(key);
            }
        }
        return candidateKeys.size();
    }

    public void subsets(List<List<String>> answer, StringBuilder key, StringBuilder elem, String[] relation, int index) {
        if (index != 0) {
            answer.add(List.of(new StringBuilder(key).toString(), new StringBuilder(elem).toString()));
        }

        for (int i = index; i < relation.length; i++) {
            elem.append(relation[i]);
            key.append(String.valueOf(i));
            subsets(answer, key, elem, relation, i + 1);
            elem.delete(elem.length() - relation[i].length(), elem.length());
            key.delete(key.length() - 1, key.length());
        }
    }
}
