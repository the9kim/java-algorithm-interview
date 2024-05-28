package org.kakao18;

public class P2_1_Secret_Map {
    public String[] solution(int n, int[] arr1, int[] arr2) {

        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            String bin = Integer.toBinaryString(arr1[i] | arr2[i]);
            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < n - bin.length(); j++) {
                sb.append(" ");
            }

            for (char c : bin.toCharArray()) {
                if (c == '1') {
                    sb.append("#");
                } else {
                    sb.append(" ");
                }
            }
            answer[i] = new String(sb);
        }
        return answer;
    }


}
