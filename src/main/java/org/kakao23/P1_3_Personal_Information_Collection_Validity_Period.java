package org.kakao23;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P1_3_Personal_Information_Collection_Validity_Period {

    public int[] solution(String today, String[] terms, String[] privacies) {
        int convertedToday = convertToDay(today);

        return findExpiredInfo(terms, privacies, convertedToday);
    }

    private int convertToDay(String today) {
        String[] tSplit = today.split("\\.");

        return (Integer.parseInt(tSplit[0]) - 2000) * 12 * 28
                + (Integer.parseInt(tSplit[1]) * 28)
                + Integer.parseInt(tSplit[2]);
    }

    private int[] findExpiredInfo(String[] terms, String[] privacies, int convertedToday) {
        Map<String, Integer> termMap = new HashMap<>();

        for (String term : terms) {
            termMap.put(term.substring(0, 1), Integer.parseInt(term.substring(2)) * 28);
        }

        List<Integer> expiredInfo = new ArrayList<>();

        for (int i = 0; i < privacies.length; i++) {
            int expireDay = convertToDay(privacies[i].substring(0, 10)) + termMap.get(privacies[i].substring(11)) - 1;

            if (convertedToday > expireDay) {
                expiredInfo.add(i + 1);
            }
        }

        return expiredInfo.stream().mapToInt(Integer::intValue).toArray();
    }

}
