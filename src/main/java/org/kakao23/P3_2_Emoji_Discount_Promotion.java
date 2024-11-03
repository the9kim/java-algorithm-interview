package org.kakao23;

import java.util.ArrayList;
import java.util.List;

public class P3_2_Emoji_Discount_Promotion {

    public int[] solution(int[][] users, int[] emoticons) {
        List<List<Integer>> combinations = new ArrayList<>();

        calculateCombinations(combinations, new ArrayList<>(), emoticons.length);

        List<int[]> results = findOptimalCombination(users, emoticons, combinations);

        return results.get(0);

    }

    private void calculateCombinations(List<List<Integer>> combinations, List<Integer> elems, int size) {

        if (elems.size() == size) {
            combinations.add(new ArrayList<>(elems));
            return;
        }

        for (int i = 10; i <= 40; i += 10) {
            elems.add(i);
            calculateCombinations(combinations, elems, size);
            elems.remove(elems.size() - 1);
        }
    }

    private List<int[]> findOptimalCombination(int[][] users, int[] emoticons, List<List<Integer>> combinations) {

        List<int[]> results = new ArrayList<>();

        for (List<Integer> rates : combinations) {

            int serviceUsers = 0;
            int revenue = 0;

            for (int[] user : users) {

                int limitRate = user[0];
                int limitPrice = user[1];

                int totalPurchase = 0;

                for (int i = 0; i < rates.size(); i++) {
                    if (limitRate <= rates.get(i)) {
                        totalPurchase += emoticons[i] * (1 - rates.get(i) * 0.01);
                    }
                }

                if (totalPurchase >= limitPrice) {
                    serviceUsers++;
                } else {
                    revenue += totalPurchase;
                }
            }
            results.add(new int[]{serviceUsers, revenue});
        }

        results.sort((a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(b[1], a[1]);
            } else {
                return Integer.compare(b[0], a[0]);
            }
        });

        return results;
    }
}
