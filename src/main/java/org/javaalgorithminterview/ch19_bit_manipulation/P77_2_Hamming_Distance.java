package org.javaalgorithminterview.ch19_bit_manipulation;

public class P77_2_Hamming_Distance {

    public int hammingDistance(int x, int y) {
        int xor = x ^ y;

        return Integer.bitCount(xor);
    }
}
