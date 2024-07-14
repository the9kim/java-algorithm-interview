package org.kakao23;

public class P4_1_Representable_Binary_Tree {

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
            long size = 0;
            for (int j = 1; j <= 63; j = j * 2 + 1) {
                if (num < Math.pow(2, j)) {
                    size = j;
                    break;
                }
            }
            String bin = Long.toBinaryString(num);

            // 2.
            String padding = "0".repeat((int) (size - bin.length()));
            bin = padding + bin;

            // 3.
            if (deserializable(bin.toCharArray(), 0, bin.length() - 1, false)) {
                answer[i] = 1;
            } else {
                answer[i] = 0;
            }
        }
        return answer;
    }

    public boolean deserializable(char[] bin, int leftIdx, int rightIdx, boolean dummy) {
        if (leftIdx == rightIdx && dummy == true && bin[leftIdx] == '1') {
            return false;
        }
        else if (leftIdx == rightIdx) {
            return true;
        }

        int rootIdx = leftIdx + (rightIdx - leftIdx) / 2;
        int rootVal = bin[rootIdx];

        if (dummy == true && rootVal == '1') {
            return false;
        }

        dummy = rootVal == '0' ? true : false;

        if (!deserializable(bin, leftIdx, rootIdx - 1, dummy)) {
            return false;
        }
        if (!deserializable(bin, rootIdx + 1, rightIdx, dummy)) {
            return false;
        }
        return true;

    }
}
