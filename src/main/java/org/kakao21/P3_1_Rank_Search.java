package org.kakao21;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P3_1_Rank_Search {
    /**
     * Time-Exceeded
     *
     * 1. Calculate information maps based on each category
     * 2. Get intersection lists from queries
     * 3. Count the number of people who get higher score than the condition
     */
    public int[] solution(String[] info, String[] query) {
        // 1.
        Map<String, List<Integer>> langMap = new HashMap<>();
        Map<String, List<Integer>> jobMap = new HashMap<>();
        Map<String, List<Integer>> careerMap = new HashMap<>();
        Map<String, List<Integer>> foodMap = new HashMap<>();
        Map<Integer, Integer> scoreMap = new HashMap<>();

        for (int id = 0; id < info.length; id++) {
            String[] infoArr = info[id].split("\\s");
            String lang = infoArr[0];
            String job = infoArr[1];
            String career = infoArr[2];
            String food = infoArr[3];
            int score = Integer.valueOf(infoArr[4]);

            langMap.putIfAbsent(lang, new ArrayList<>());
            langMap.get(lang).add(id);

            jobMap.putIfAbsent(job, new ArrayList<>());
            jobMap.get(job).add(id);

            careerMap.putIfAbsent(career, new ArrayList<>());
            careerMap.get(career).add(id);

            foodMap.putIfAbsent(food, new ArrayList<>());
            foodMap.get(food).add(id);

            scoreMap.put(id, score);
        }

        // 2.
        int[] answer = new int[query.length];

        for (int i = 0; i < query.length; i++) {
            String q = query[i];
            String[] qArr = q.replaceAll("and", "").split("\\s+");
            String lang = qArr[0];
            String job = qArr[1];
            String career = qArr[2];
            String food = qArr[3];
            int score = Integer.valueOf(qArr[4]);

            List<Integer> union = new ArrayList<>();
            for (int id = 0; id < info.length; id++) {
                union.add(id);
            }

            if (!lang.equals("-")) {
                union.retainAll(langMap.get(lang));
            }
            if (!job.equals("-")) {
                union.retainAll(jobMap.get(job));
            }
            if (!career.equals("-")) {
                union.retainAll(careerMap.get(career));
            }
            if (!food.equals("-")) {
                union.retainAll(foodMap.get(food));
            }

            int count = 0;
            for (Integer id : union) {
                if (scoreMap.get(id) >= score) {
                    count++;
                }
            }
            answer[i] = count;
        }

        return answer;
    }
}
