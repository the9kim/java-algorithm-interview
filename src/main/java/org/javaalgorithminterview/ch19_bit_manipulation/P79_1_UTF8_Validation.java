package org.javaalgorithminterview.ch19_bit_manipulation;

public class P79_1_UTF8_Validation {


    /**
     * 1. Convert an input integer to a binary String
     * 2. Check if it is a valid UTF-8 pattern.
     */
    public boolean validUtf8(int[] data) {

        // 1.
        String[] binData = new String[data.length];
        for (int i = 0; i < data.length; i++) {
            binData[i] = String.format("%8s", Integer.toBinaryString(data[i])).replace(' ', '0');
        }

        // 2.
        int restNum = 0;
        for (String bin : binData) {
            if (restNum > 0) {
                if (!bin.startsWith("10")) {
                    return false;
                }
                restNum -= 1;
            } else {
                if (bin.startsWith("0")) {
                    continue;
                } else if (bin.startsWith("110")) {
                    restNum = 1;
                } else if (bin.startsWith("1110")) {
                    restNum = 2;
                } else if (bin.startsWith("11110")) {
                    restNum = 3;
                } else {
                    return false;
                }
            }
        }
        return restNum == 0;
    }
}
