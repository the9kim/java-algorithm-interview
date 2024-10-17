package org.kakao23;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P1_1_Personal_Information_Collection_Validity_Period {

    /**
     * The solution using LocalTime library
     * <p>
     * 1. Calculate a validity period Array
     * 2. Compare today and the validity period Array
     */
    public int[] solution(String today, String[] terms, String[] privacies) {

        LocalDate tday = convertToDateTime(today);

        Map<String, Integer> termsMap = createTermsMap(terms);

        return findExpiredInfo(termsMap, privacies, tday);
    }

    private LocalDate convertToDateTime(String date) {
        int[] tArr = Arrays.stream(date.split("\\."))
                .mapToInt(Integer::parseInt)
                .toArray();

        return LocalDate.of(tArr[0], tArr[1], tArr[2]);
    }

    private Map<String, Integer> createTermsMap(String[] terms) {

        Map<String, Integer> termsMap = new HashMap<>();

        for (String term : terms) {
            termsMap.put(term.substring(0, 1), Integer.parseInt(term.substring(2)));
        }

        return termsMap;
    }

    private int[] findExpiredInfo(Map<String, Integer> termsMap, String[] privacies, LocalDate today) {
        List<Integer> expiredInfo = new ArrayList<>();

        for (int i = 0; i < privacies.length; i++) {
            LocalDate date = convertToDateTime(privacies[i].substring(0, 10));
            int period = termsMap.get(privacies[i].substring(11));
            LocalDate expireDate = date.plusMonths(period).minusDays(1);

            if (today.isAfter(expireDate)) {
                expiredInfo.add(i + 1);
            }
        }

        return expiredInfo.stream().mapToInt(Integer::intValue).toArray();
    }
}
