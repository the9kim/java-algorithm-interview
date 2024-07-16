package org.kakao23;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Memory Exeeded
 */

public class P5_2_Merge_Table {
    String[][] values = new String[51][51];
    Map<Integer, List<int[]>> neighbors = new HashMap<>();


    public String[] solution(String[] commands) {
        // 0. Init data structure
        for (int r = 0; r < 51; r++) {
            for (int c = 0; c < 51; c++) {
                values[r][c] = "";

                int idx = 100 * r + c;
                neighbors.putIfAbsent(idx, new ArrayList<>());
                neighbors.get(idx).add(new int[]{r, c});
            }
        }

        // 1. Read commands
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
                unmerge(Integer.parseInt(command[1]), Integer.parseInt(command[2]));
            } else {
                String val = print(Integer.parseInt(command[1]), Integer.parseInt(command[2]));
                if (!val.equals("")) {
                    answer.add(val);
                } else {
                    answer.add("EMPTY");
                }
            }
        }
        return answer.toArray(new String[0]);
    }

    public void update(int r, int c, String v) {
        int idx = r * 100 + c;

        for (int[] n : neighbors.get(idx)) {
            values[n[0]][n[1]] = v;
        }
    }

    public void update(String v1, String v2) {
        for (int r = 0; r < 51; r++) {
            for (int c = 0; c < 51; c++) {
                if (values[r][c].equals(v1)) {
                    values[r][c] = v2;
                }
            }
        }
    }

    public void merge(int r1, int c1, int r2, int c2) {
        if (r1 == r2 && c1 == c2) {
            return;
        }

        String newValue = !values[r1][c1].equals("") ? values[r1][c1] : values[r2][c2];

        int idx1 = r1 * 100 + c1;
        int idx2 = r2 * 100 + c2;

        List<int[]> n1 = neighbors.get(idx1);
        List<int[]> n2 = neighbors.get(idx2);
        n1.addAll(n2);

        for (int[] i : n1) {
            values[i[0]][i[1]] = newValue;
            neighbors.put(i[0] * 100 + i[1], n1);
        }
    }

    public void unmerge(int r1, int c1) {
        String value = values[r1][c1];

        int idx = r1 * 100 + c1;
        for (int[] i : neighbors.get(idx)) {
            values[i[0]][i[1]] = "";
            int nIdx = i[0] * 100 + i[1];
            neighbors.put(nIdx, new ArrayList<>());
            neighbors.get(nIdx).add(new int[]{i[0], i[1]});
        }
        values[r1][c1] = value;
    }

    public String print(int r1, int c1) {
        return values[r1][c1];
    }
}
