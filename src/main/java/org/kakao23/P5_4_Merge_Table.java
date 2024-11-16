package org.kakao23;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P5_4_Merge_Table {
    static class Cell {
        String value;
        Set<Cell> merged;

        public void init() {
            value = "EMPTY";
            merged = new HashSet<>();
            merged.add(this);
        }
    }

    Cell[][] table = new Cell[51][51];

    public String[] solution(String[] commands) {

        initCells();

        List<String> results = new ArrayList<>();

        for (String comm : commands) {
            String[] command = comm.split(" ");

            if (command[0].equals("UPDATE")) {
                if (command.length == 4) {
                    update(
                            Integer.parseInt(command[1]),
                            Integer.parseInt(command[2]),
                            command[3]
                    );
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
                int row = Integer.parseInt(command[1]);
                int col = Integer.parseInt(command[2]);
                results.add(table[row][col].value);
            }
        }
        return results.toArray(new String[0]);
    }

    private void update(int row, int col, String updateValue) {
        for (Cell c : table[row][col].merged) {
            c.value = updateValue;
        }
    }

    private void update(String from, String to) {
        for (int row = 1; row <= 50; row++) {
            for (int col = 1; col <= 50; col++) {
                if (table[row][col].value.equals(from)) {
                    table[row][col].value = to;
                }
            }
        }
    }

    private void merge(int row1, int col1, int row2, int col2) {
        String updateVal = !table[row1][col1].value.equals("EMPTY") ? table[row1][col1].value : table[row2][col2].value;
        Set<Cell> mergeGroup = new HashSet<>();
        mergeGroup.addAll(table[row1][col1].merged);
        mergeGroup.addAll(table[row2][col2].merged);

        for (Cell merged : mergeGroup) {
            merged.value = updateVal;
            merged.merged = mergeGroup;
        }
    }

    private void unmerge(int row, int col) {
        String representative = table[row][col].value;
        Set<Cell> group = table[row][col].merged;

        for (Cell c : group) {
            c.init();
        }
        table[row][col].value = representative;
    }

    private void initCells() {
        for (int r = 1; r <= 50; r++) {
            for (int c = 1; c <= 50; c++) {
                Cell cell = new Cell();
                cell.init();
                table[r][c] = cell;
            }
        }
    }
}
