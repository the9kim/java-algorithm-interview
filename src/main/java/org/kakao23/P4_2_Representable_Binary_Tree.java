package org.kakao23;

import java.util.List;

public class P4_2_Representable_Binary_Tree {

    /**
     * 1. Convert input numbers to binary number arrays
     * 2. Add padding to transform the binary number arrays into binary trees
     * 3. Check if the arrays are deserializable
     */
    public int[] solution(long[] numbers) {

        int[] answer = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            long num = numbers[i];
            // 1.
            String bin = Long.toBinaryString(num);

            int nodeNums = 1;
            int n = 0;
            while (bin.length() > nodeNums){
                n++;
                nodeNums += Math.pow(2, n);
            }

            // 2.
            String padding = "0".repeat((int) (nodeNums - bin.length()));
            bin = padding + bin;

            // 3.
            if (deserializable(bin, 0, bin.length() - 1)) {
                answer[i] = 1;
            } else {
                answer[i] = 0;
            }
        }
        return answer;
    }

    public boolean deserializable(String bin, int leftIdx, int rightIdx) {
        if (leftIdx == rightIdx) {
            return true;
        }

        int index = leftIdx + (rightIdx - leftIdx) / 2;

        boolean left = deserializable(bin, leftIdx, index - 1);
        boolean right = deserializable(bin, index + 1, rightIdx);


        if (!left || !right || bin.charAt(index) == '0') {
            return false;
        }
        return true;
    }
}
