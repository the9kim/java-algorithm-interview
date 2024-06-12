package org.kakao20;

public class P3_1_Lock_and_Key {
    /**
     * 1. Add an offset to the lock
     * 2. Utilize iteration for moving the key on the expanded lock.
     * 3. Utilize iteration for rotating the key
     * 4. Check if the lock can be opened
     */
    public boolean solution(int[][] key, int[][] lock) {
        int offset = lock.length - 1;

        // 2.
        for (int row = 0; row < offset + lock.length; row++) {
            for (int col = 0; col < offset + lock[0].length; col++) {

                // 3.
                for (int i = 1; i <= 4; i++) {

                    // 1.
                    int[][] expandedArr = getExpandedArr(lock, offset);

                    pasteKeyToLock(key, expandedArr, row, col);

                    // 4.
                    if (validateLock(expandedArr, lock.length, offset)) {
                        return true;
                    }
                    key = rotate(key);
                }
            }
        }
        return false;
    }

    public void pasteKeyToLock(int[][] key, int[][] expandedArr, int row, int col) {
        for (int r = 0; r < key.length; r++) {
            for (int c = 0; c < key[0].length; c++) {
                if (expandedArr[row + r][col + c] == 1 && key[r][c] == 1) {
                    expandedArr[row + r][col + c] = 0;
                } else if (expandedArr[row + r][col + c] == 0 && key[r][c] == 1) {
                    expandedArr[row + r][col + c] = key[r][c];
                }
            }
        }
    }

    public boolean validateLock(int[][] expandedArr, int length, int offset) {
        for (int r = 0; r < length; r++) {
            for (int c = 0; c < length; c++) {
                if (expandedArr[offset + r][offset + c] != 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public int[][] getExpandedArr(int[][] lock, int offset) {
        int[][] expandedArr = new int[lock.length + 2 * offset][lock[0].length + 2 * offset];
        for (int r = 0; r < lock.length; r++) {
            for (int c = 0; c < lock[0].length; c++) {
                expandedArr[r + offset][c + offset] = lock[r][c];
            }
        }
        return expandedArr;
    }

    public int[][] rotate(int[][] key) {
        int[][] rotated = new int[key.length][key[0].length];

        for (int r = 0; r < key.length; r++) {
            for (int c = 0; c < key[0].length; c++) {
                rotated[r][c] = key[key.length - 1 - c][r];
            }
        }
        return rotated;
    }
}
