package org.kakao23;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P1_3_Personal_Information_Collection_Validity_Period {

    int today;

    public int[] solution(String today, String[] terms, String[] privacies) {
        this.today = convertDate(today);

        Map<String, Integer> termMap = createTermMap(terms);

        Map<Integer, Integer> expiredMap = createExpiredMap(termMap, privacies);

        return findExpiredPrivacies(expiredMap);
    }

    private int convertDate(String date) {
        String[] dateSplit = date.split("\\.");
        int year = Integer.parseInt(dateSplit[0]);
        int month = Integer.parseInt(dateSplit[1]);
        int day = Integer.parseInt(dateSplit[2]);

        return (year - 2000) * 12 * 28 + month * 28 + day;
    }

    private Map<String, Integer> createTermMap(String[] terms) {
        Map<String, Integer> termMap = new HashMap<>();

        for (String term : terms) {
            String[] termArr = term.split(" ");
            termMap.put(termArr[0], Integer.parseInt(termArr[1]) * 28);
        }

        return termMap;
    }

    private Map<Integer, Integer> createExpiredMap(Map<String, Integer> termMap, String[] privacies) {

        Map<Integer, Integer> expiredMap = new HashMap<>();

        for (int i = 0; i < privacies.length; i++) {
            String[] pSplit = privacies[i].split(" ");
            int start = convertDate(pSplit[0]);
            int duration = termMap.get(pSplit[1]);

            expiredMap.put(i + 1, start + duration - 1);
        }

        return expiredMap;
    }

    private int[] findExpiredPrivacies(Map<Integer, Integer> expiredMap) {

        List<Integer> results = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : expiredMap.entrySet()) {
            if (today > entry.getValue()) {
                results.add(entry.getKey());
            }
        }

        Collections.sort(results);

        return results.stream().mapToInt(Integer::intValue).toArray();
    }


}
