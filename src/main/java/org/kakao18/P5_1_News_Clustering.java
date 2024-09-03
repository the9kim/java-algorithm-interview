package org.kakao18;

import java.util.HashMap;
import java.util.Map;

public class P5_1_News_Clustering {

    /**
     * 1. Create frequency maps for bigrams in both strings
     * 2. Calculate intersection and union of bigram frequency maps
     * 3. Calculate the Jaccard similarity
     */

    public int solution(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        // Step 1
        Map<String, Integer> counter1 = createBigramFrequencyMap(str1);
        Map<String, Integer> counter2 = createBigramFrequencyMap(str2);


        // step 2
        int intersectionSum = 0;
        int unionSum = 0;

        for (Map.Entry<String, Integer> entry : counter1.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();

            if (counter2.containsKey(key)) {
                intersectionSum += Math.min(counter2.get(key), value);
                unionSum += Math.max(counter2.get(key), value);
            } else {
                unionSum += value;
            }
        }

        for (Map.Entry<String, Integer> entry : counter2.entrySet()) {
            if (!counter1.containsKey(entry.getKey())) {
                unionSum += entry.getValue();
            }
        }

        // step3
        if (intersectionSum == 0 && unionSum == 0) {
            return 65536;
        }

        return (int) (((double) intersectionSum / unionSum) * 65536);
    }

    private Map<String, Integer> createBigramFrequencyMap(String str) {
        Map<String, Integer> bigramMap = new HashMap<>();
        String pattern = "[a-z]{2}";

        for (int i = 0; i < str.length() - 1; i++) {
            String bigram = str.substring(i, i + 2);

            if (bigram.matches(pattern)) {
                bigramMap.put(bigram, bigramMap.getOrDefault(bigram, 0) + 1);
            }
        }
        return bigramMap;
    }
}
