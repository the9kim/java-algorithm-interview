package org.kakao18;

public class P2_2_Secret_Map {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            answer[i] = String.format(
                    //  string concatenation with implicit type conversion
                    "%" + n + "s",
                    Integer.toBinaryString(arr1[i] | arr2[i]))
                    .replaceAll("1", "#")
                    .replaceAll("0", " ");
        }
        return answer;
    }

}
