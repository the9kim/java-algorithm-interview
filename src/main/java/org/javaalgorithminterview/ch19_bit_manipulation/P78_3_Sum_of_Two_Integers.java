package org.javaalgorithminterview.ch19_bit_manipulation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class P78_3_Sum_of_Two_Integers {

    public int getSum(int a, int b) {
        String binA = Integer.toBinaryString(a);
        String binB = Integer.toBinaryString(b);

        binA = "0".repeat(32 - binA.length()) + binA;
        binB = "0".repeat(32 - binB.length()) + binB;

        List<Integer> sum = new ArrayList<>();
        int carry = 0;

        for (int i = 31; i >= 0; i--) {
            int bitA = Character.getNumericValue(binA.charAt(i));
            int bitB = Character.getNumericValue(binB.charAt(i));

            int s1 = bitA ^ bitB;
            int co1 = bitA & bitB;

            int s2 = carry ^ s1;
            int co2 = carry & s1;

            carry = co1 | co2;

            sum.add(0, s2);
        }

        return Integer.parseUnsignedInt(
                sum.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(""))
                , 2);
    }
}
