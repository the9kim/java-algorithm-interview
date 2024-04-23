package org.javaalgorithminterview.ch19_bit_manipulation;

public class P77_1_Hamming_Distance {

    public int hammingDistance(int x, int y) {
        int count = 0;

        int distance = x ^ y;

        while (distance != 0) {
            if ((distance & 1) == 1) {
                count++;
            }
            distance >>= 1;
        }
        return count;
    }
}
