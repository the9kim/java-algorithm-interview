package org.kakao23;

public class P6_2_Instruction_for_Escaping_Maze {

    static final String FAIL = "impossible";
    static final int[][] DIRECTIONS = {{1, 0}, {0, -1}, {0, 1}, {-1, 0}};
    static final String[] VECTORS = {"d", "l", "r", "u"};

    int rowSize;
    int colSize;
    int movementCount;
    String finalRoute = FAIL;

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        this.rowSize = n;
        this.colSize = m;
        this.movementCount = k;

        dfs(x - 1, y - 1, r - 1, c - 1, new StringBuilder());

        return finalRoute;
    }

    private void dfs(int srcRow, int srcCol, int dstRow, int dstCol, StringBuilder route) {
        if (route.length() > this.movementCount) {
            return;
        }

        if (!canEscape(srcRow, srcCol, dstRow, dstCol, this.movementCount - route.length())) {
            return;
        }

        if (route.length() == this.movementCount && srcRow == dstRow && srcCol == dstCol) {
            finalRoute = route.toString();
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nextRow = srcRow + DIRECTIONS[i][0];
            int nextCol = srcCol + DIRECTIONS[i][1];

            if (!canMove(nextRow, nextCol)) {
                continue;
            }
            route.append(VECTORS[i]);

            dfs(nextRow, nextCol, dstRow, dstCol, route);

            if (!finalRoute.equals(FAIL)) {
                return;
            }

            route.deleteCharAt(route.length() - 1);
        }
    }

    private boolean canEscape(int r1, int c1, int r2, int c2, int movementLeft) {
        int distance = Math.abs(r1 - r2) + Math.abs(c1 - c2);
        return distance <= movementLeft && (movementLeft - distance) % 2 == 0;
    }

    private boolean canMove(int r, int c) {
        if (r < 0 || c < 0 || r >= rowSize || c >= colSize) {
            return false;
        }
        return true;
    }

}
