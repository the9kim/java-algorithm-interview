package org.javaalgorithminterview.ch19_bit_manipulation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class P78_2_Sum_of_Two_Integers {


    public int getSum(int a, int b) {

        while (b != 0) {
            int carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }

        return a;
    }
}
