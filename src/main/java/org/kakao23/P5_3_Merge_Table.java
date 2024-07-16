package org.kakao23;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class P5_3_Merge_Table {
    String[] values = new String[51 * 51];
    Map<Integer, Set<Integer>> neighbors = new HashMap<>();

    public String[] solution(String[] commands) {
        List<String> answer = new ArrayList<>();

        for (String c : commands) {
            String[] command = c.split(" ");

            if (command[0].equals("UPDATE")) {
                if (command.length == 4) {
                    update(
                            Integer.parseInt(command[1]),
                            Integer.parseInt(command[2]),
                            command[3]);
                } else {
                    update(command[1], command[2]);
                }
            } else if (command[0].equals("MERGE")) {
                merge(
                        Integer.parseInt(command[1]),
                        Integer.parseInt(command[2]),
                        Integer.parseInt(command[3]),
                        Integer.parseInt(command[4])
                );
            } else if (command[0].equals("UNMERGE")) {
                unmerge(
                        Integer.parseInt(command[1]),
                        Integer.parseInt(command[2])
                );
            } else {
                answer.add(print(
                        Integer.parseInt(command[1]),
                        Integer.parseInt(command[2])));
            }
        }
        return answer.toArray(new String[0]);
    }

    public void update(int r, int c, String v) {
        int idx = convertToIdx(r, c);

        if (!neighbors.containsKey(idx)) {
            neighbors.put(idx, new HashSet<>());
            neighbors.get(idx).add(idx);
        }

        for (Integer i : neighbors.get(idx)) {
            values[i] = v;
        }
    }

    public void update(String v1, String v2) {
        for (int i = 0; i < 51 * 51; i++) {
            if (values[i] != null && values[i].equals(v1)) {
                values[i] = v2;
            }
        }
    }

    public void merge(int r1, int c1, int r2, int c2) {
        if (r1 == r2 && c1 == c2) {
            return;
        }

        int idx1 = convertToIdx(r1, c1);
        int idx2 = convertToIdx(r2, c2);

        // 1. Find the registering value
        String v = (values[idx1] != null && !values[idx1].equals("")) ? values[idx1] : values[idx2];


        // 2. Update the neighbors
        if (!neighbors.containsKey(idx1)) {
            neighbors.put(idx1, new HashSet<>());
            neighbors.get(idx1).add(idx1);
        }
        if (!neighbors.containsKey(idx2)) {
            neighbors.put(idx2, new HashSet<>());
            neighbors.get(idx1).add(idx2);
        }

        Set<Integer> newNeighbors = new HashSet<>();
        newNeighbors.addAll(neighbors.get(idx1));
        newNeighbors.addAll(neighbors.get(idx2));

        for (Integer idx : newNeighbors) {
            values[idx] = v;
            neighbors.put(idx, newNeighbors);
        }
    }

    public void unmerge(int r, int c) {
        int idx = convertToIdx(r, c);
        String remainingValue = values[idx];

        // 1. Initialize the values and neighbors
        if (!neighbors.containsKey(idx)) {
            return;
        }

        for (Integer i: neighbors.get(idx)) {
            values[i] = "";
            neighbors.remove(i);
        }

        // 2. Set the remaining value and neighbors for the input cell
        values[idx] = remainingValue;
        neighbors.put(idx, new HashSet<>());
        neighbors.get(idx).add(idx);
    }

    public String print(int r, int c) {
        int idx = convertToIdx(r, c);
        if (values[idx] == null || values[idx].equals("")) {
            return "EMPTY";
        }
        return values[idx];
    }

    public int convertToIdx(int r, int c) {
        return r * 51 + c;
    }
}
