package org.javaalgorithminterview.ch19_bit_manipulation;

public class P80_1_Number_of_1_Bits {
    public int hammingWeight(int n) {
        int count = 0;

        while (n > 0) {
            if ((n & 0b1) == 1) {
                count++;
            }
            n >>= 1;
        }
        return count;
    }
}
