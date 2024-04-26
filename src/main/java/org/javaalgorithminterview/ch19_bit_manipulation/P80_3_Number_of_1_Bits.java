package org.javaalgorithminterview.ch19_bit_manipulation;

public class P80_3_Number_of_1_Bits {
    /**
     * The book solution
     *
     * When you perform the bitwise AND operation between n and n-1, the count of 1s in n decreases by 1
     *
     */
    public int hammingWeight(int n) {
        int count = 0;

        while (n != 0) {
            n &= n - 1;
            count++;
        }
        return count;
    }
}
