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
        // 1.
        Map<String, Integer> termsMap = new HashMap<>();
        for (String term : terms) {
            String[] split = term.split(" ");
            termsMap.put(split[0], Integer.parseInt(split[1]));
        }
        LocalDate[] validityPeriod = new LocalDate[privacies.length];
        for (int i = 0; i < validityPeriod.length; i++) {
            String[] privacy = privacies[i].split(" ");
            int term = termsMap.get(privacy[1]);
            validityPeriod[i] = calValidityPeriod(privacy[0], term);
        }

        // 2.
        List<Integer> answer = new ArrayList<>();
        int[] todaySplit = Arrays.stream(today.split("\\."))
                .mapToInt(Integer::valueOf)
                .toArray();
        LocalDate todayDate = LocalDate.of(
                todaySplit[0], todaySplit[1], todaySplit[2]);

        for (int i = 0; i < validityPeriod.length; i++) {
            if (todayDate.isAfter(validityPeriod[i])) {
                answer.add(i + 1);
            }
        }
        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public LocalDate calValidityPeriod(String privacy, Integer term) {
        String[] split = privacy.split("\\.");
        int year = Integer.parseInt(split[0]);
        int month = Integer.parseInt(split[1]);
        int day = Integer.parseInt(split[2]);

        LocalDate date = LocalDate.of(year, month, day);
        return date.plusMonths(term).minusDays(1);
    }
}
