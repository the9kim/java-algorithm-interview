package org.kakao23;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P1_2_Personal_Information_Collection_Validity_Period {

    /**
     * 1. transform date to days
     * 2. Compare today and the validity period Array
     */
    public int[] solution(String today, String[] terms, String[] privacies) {
        Map<String, Integer> termsMap = new HashMap<>();
        for (String term : terms) {
            termsMap.put(term.substring(0, 1), Integer.parseInt(term.substring(2)) * 28);
        }

        List<Integer> answer = new ArrayList<>();

        int tDay = convertToDay(today);
        for (int i = 0; i < privacies.length; i++) {
            int cDay = convertToDay(privacies[i]);
            int validPeriod = termsMap.get(privacies[i].substring(11, 12));
            if (tDay > cDay + validPeriod - 1) {
                answer.add(i + 1);
            }
        }
        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public int convertToDay(String date) {
        int day = Integer.parseInt(date.substring(2, 4)) * 12 * 28;
        day += Integer.parseInt(date.substring(5, 7)) * 28;
        day += Integer.parseInt(date.substring(8, 10));

        return day;
    }


}
