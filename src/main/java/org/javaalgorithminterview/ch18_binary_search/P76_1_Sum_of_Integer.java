package org.javaalgorithminterview.ch18_binary_search;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class P76_1_Sum_of_Integer {


    /**
     * 1. Convert an int to a bitwise string
     * 2. Implement input and output of a full adder
     * 3. Convert the sum of the List type to a single int
     */
    public int getSum(int a, int b) {

        // 1
        String binA = String.format("%32s", Integer.toBinaryString(a)).replace(' ', '0');
        String binB = String.format("%32s", Integer.toBinaryString(b)).replace(' ', '0');


        // 2
        List<Character> result = new ArrayList<>();

        int carry = 0;
        int sum;

        for (int i = 0; i < 32; i++) {
            int A = Character.getNumericValue(binA.charAt(31 - i));
            int B = Character.getNumericValue(binB.charAt(31 - i));

            int Q1 = A & B;
            int Q2 = A ^ B;
            int Q3 = Q2 & carry;

            sum = Q2 ^ carry;
            carry = Q1 | Q3;

            result.add(0, Character.forDigit(sum, 2));
        }

        // 3
        return Integer.parseUnsignedInt(
                result.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(""))
                , 2);
    }
}
