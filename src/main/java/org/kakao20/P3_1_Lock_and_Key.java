package org.kakao20;

public class P3_1_Lock_and_Key {
    /**
     * 1. Add an offset to the lock
     * 2. Utilize iteration for moving the key on the expanded lock.
     * 3. Utilize iteration for rotating the key
     * 4. Check if the lock can be opened
     */
    public boolean solution(int[][] key, int[][] lock) {
        int offset = key.length - 1;
        int lockSize = lock.length;

        for (int r = 0; r < lock.length + offset; r++) {
            for (int c = 0; c < lock.length + offset; c++) {

                for (int rot = 1; rot <= 4; rot++) {
                    int[][] expanded = expandLock(lock, offset);

                    pasteKeyToLock(expanded, key, r, c);

                    if (canUnlock(expanded, lockSize, offset)) {
                        return true;
                    }
                    key = rotate(key);
                }
            }
        }

        return false;
    }

    public int[][] expandLock(int[][] lock, int offset) {
        int[][] expanded = new int[lock.length + 2 * offset][lock.length + 2 * offset];

        for (int r = 0; r < lock.length; r++) {
            for (int c = 0; c < lock[0].length; c++) {
                expanded[r + offset][c + offset] = lock[r][c];
            }
        }

        return expanded;
    }

    public void pasteKeyToLock(int[][] expanded, int[][] key, int rowOffset, int colOffset) {

        for (int r = 0; r < key.length; r++) {
            for (int c = 0; c < key.length; c++) {
                int expandedVal = expanded[r + rowOffset][c + colOffset];
                int keyVal = key[r][c];

                if (expandedVal == 1 && keyVal == 1) {
                    expanded[r + rowOffset][c + colOffset] = 0;
                } else if (expandedVal == 0 && keyVal == 1) {
                    expanded[r + rowOffset][c + colOffset] = 1;
                }
            }
        }
    }

    public boolean canUnlock(int[][] expanded, int lockSize, int offset) {
        for (int r = 0; r < lockSize; r++) {
            for (int c = 0; c < lockSize; c++) {
                if (expanded[r + offset][c + offset] == 0) {
                    return false;
                }
            }
        }
        return true;
    }


    public int[][] rotate(int[][] key) {
        int keySize = key.length;
        int[][] rotated = new int[keySize][keySize];

        for (int r = 0; r < keySize; r++) {
            for (int c = 0; c < keySize; c++) {
                rotated[c][keySize - 1 - r] = key[r][c];
            }
        }
        return rotated;
    }

}
