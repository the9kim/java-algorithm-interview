package org.kakao23;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Runtime-Error
 */
public class P5_1_Merge_Table {
    static class Cell {
        String value;
        Set<int[]> neighbors;

        public Cell(String value, int row, int col) {
            this.value = value;
            this.neighbors = new HashSet<>();
            this.neighbors.add(new int[]{row, col});
        }
    }

    static class Table {
        Cell[][] table = new Cell[50][50];

        public void update(int row, int col, String val) {
            if (table[row][col] == null) {
                table[row][col] = new Cell(val, row, col);
            }

            Cell cell = table[row][col];

            for (int[] n : cell.neighbors) {
                int r = n[0];
                int c = n[1];
                table[r][c].value = val;
            }

        }

        public void update(String val1, String val2) {
            List<int[]> indexes = new ArrayList<>();

            for (int r = 0; r < table.length; r++) {
                for (int c = 0; c < table[0].length; c++) {
                    if (table[r][c] != null && table[r][c].value.equals(val1)) {
                        indexes.add(new int[]{r, c});
                    }
                }
            }
            for (int[] i : indexes) {
                update(i[0], i[1], val2);
            }
        }

        public void merge(int row1, int col1, int row2, int col2) {

            // 1.
            if (row1 == row2 && col1 == col2) {
                return;
            }

            // 2.
            Cell cell1 = table[row1][col1];
            Cell cell2 = table[row2][col2];

            if (cell1 != null && cell2 != null) {
                update(row2, col2, cell1.value);

            } else if (cell1 != null && cell2 == null) {
                table[row2][col2] = new Cell("", row2, col2);
                cell2 = table[row2][col2];
                update(row2, col2, cell1.value);

            } else if (cell1 == null && cell2 != null) {
                table[row1][col1] = new Cell("", row1, col1);
                cell1 = table[row1][col1];
                update(row1, col1, cell2.value);
            } else {
                table[row1][col1] = new Cell("", row1, col1);
                table[row2][col2] = new Cell("", row2, col2);
                cell1 = table[row1][col1];
                cell2 = table[row2][col2];
            }

            // 3.
            Set<int[]> neighbors = cell1.neighbors;
            neighbors.addAll(cell2.neighbors);

            for (int[] n : cell1.neighbors) {
                table[n[0]][n[1]].neighbors = neighbors;
            }
            for (int[] n : cell2.neighbors) {
                table[n[0]][n[1]].neighbors = neighbors;
            }
        }

        public void unmerge(int row, int col) {
            if (table[row][col] == null) {
                return;
            }
            Cell cell = table[row][col];
            String finalValue = cell.value;

            for (int[] n : cell.neighbors) {
                Cell neighbor = table[n[0]][n[1]];
                neighbor.value = "";
                neighbor.neighbors = new HashSet<>();

            }
            cell.value = finalValue;
        }

        public String print(int row, int col) {
            return table[row][col].value;
        }

        public boolean isEmpty(int row, int col) {
            return table[row][col] == null;
        }
    }


    public String[] solution(String[] commands) {
        List<String> answer = new ArrayList<>();
        Table table = new Table();

        for (String c : commands) {
            String[] command = c.split(" ");

            if (command[0].equals("UPDATE")) {
                if (command.length == 4) {
                    int row = Integer.parseInt(command[1]) - 1;
                    int col = Integer.parseInt(command[2]) - 1;
                    String val = command[3];
                    table.update(row, col, val);
                } else {
                    String val1 = command[1];
                    String val2 = command[2];
                    table.update(val1, val2);
                }

            } else if (command[0].equals("MERGE")) {
                int row1 = Integer.parseInt(command[1]) - 1;
                int col1 = Integer.parseInt(command[2]) - 1;
                int row2 = Integer.parseInt(command[3]) - 1;
                int col2 = Integer.parseInt(command[4]) - 1;

                table.merge(row1, col1, row2, col2);

            } else if (command[0].equals("UNMERGE")) {
                int row = Integer.parseInt(command[1]) - 1;
                int col = Integer.parseInt(command[2]) - 1;
                table.unmerge(row, col);

            } else {
                int row = Integer.parseInt(command[1]) - 1;
                int col = Integer.parseInt(command[2]) - 1;

                if (table.isEmpty(row, col)) {
                    answer.add("EMPTY");
                } else if (table.table[row][col].value.equals("")) {
                    answer.add("EMPTY");
                } else {
                    answer.add(table.print(row, col));
                }

            }
        }
        return answer.toArray(new String[answer.size()]);
    }
}
