package org.javaalgorithminterview.ch19_bit_manipulation;

public class P79_2_UTF8_Validation {


    /**
     * The book solution
     *
     * 1. Utilizes while loop for the input array with a pointer
     * 2. Verifies Most significant bits of the first byte using shifting operations(>>)
     * 3. Check if the rest bytes is valid format of UTF-8
     */
    public boolean validUtf8(int[] data) {
        int start = 0;

        // 1.
        while (start < data.length) {
            if (data[start] >> 3 == 0b11110 && checkRestBytes(data, start, 3)) {
                start += 4;
            } else if (data[start] >> 4 == 0b1110 && checkRestBytes(data, start, 2)) {
                start += 3;
            } else if (data[start] >> 5 == 0b110 && checkRestBytes(data, start, 1)) {
                start += 2;
            } else if (data[start] >> 7 == 0b0) {
                start += 1;
            } else {
                return false;
            }
        }
        return true;
    }

    private boolean checkRestBytes(int[] data, int start, int size) {
        // 3
        for (int i = start + 1; i < start + 1 + size; i++) {
            if (i >= data.length || data[i] >> 6 != 0b10) {
                return false;
            }
        }
        return true;
    }
}
