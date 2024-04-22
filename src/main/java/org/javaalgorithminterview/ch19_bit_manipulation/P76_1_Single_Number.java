package org.javaalgorithminterview.ch19_bit_manipulation;

public class P76_1_Single_Number {

    /**
     * The book solution using XOR operation
     */
    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }
}
