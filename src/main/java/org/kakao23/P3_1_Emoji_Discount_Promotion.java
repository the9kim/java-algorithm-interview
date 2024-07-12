package org.kakao23;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class P3_1_Emoji_Discount_Promotion {
    /**
     * 1. Calculate numbers of cases for discount rates
     * 2. Calculate the number of users that join the service and sales revenue
     */
    public int[] solution(int[][] users, int[] emoticons) {
        // 1.
        List<List<Integer>> combinations = new ArrayList<>();
        int[] rates = {10, 20, 30, 40};
        getCombinations(combinations, emoticons, rates, new ArrayList<>());

        // 2.
        List<int[]> answerList = new ArrayList<>();
        for (List<Integer> comb : combinations) {

            int serviceUsers = 0;
            int avenue = 0;

            for (int[] user : users) {
                int minPercent = user[0];
                int minAmount = user[1];

                int purchase = 0;

                for (int i = 0; i < emoticons.length; i++) {
                    if (comb.get(i) >= minPercent) {
                        purchase += emoticons[i] * (1 - comb.get(i) * 0.01);
                    }
                }
                if (purchase < minAmount) {
                    avenue += purchase;
                } else {
                    serviceUsers += 1;
                }
            }
            answerList.add(new int[]{serviceUsers, avenue});
        }

        answerList.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] != b[0]) {
                    return Integer.compare(b[0], a[0]);
                } else {
                    return Integer.compare(b[1], a[1]);
                }
            }
        });
        return answerList.get(0);
    }

    public void getCombinations(List<List<Integer>> comb, int[] emoticons, int[] rates, List<Integer> elems) {
        if (elems.size() == emoticons.length) {
            comb.add(new ArrayList<>(elems));
            return;
        }

        for (int i = 0; i <= 3; i++) {
            elems.add((rates[i]));
            getCombinations(comb, emoticons, rates, elems);
            elems.remove(elems.size() - 1);
        }
    }
}
