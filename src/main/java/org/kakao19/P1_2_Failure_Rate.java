package org.kakao19;

import java.util.HashMap;
import java.util.Map;

public class P1_2_Failure_Rate {

    public int[] solution(int N, int[] stages) {
        int playersLeft = stages.length;

        Map<Integer, Integer> usersOnStageMap = createUserCounterMap(stages, N);

        Map<Integer, Double> failureRateOnStageMap = createFailureRateMap(N, usersOnStageMap, playersLeft);

        return failureRateOnStageMap.entrySet().stream()
                .sorted(Map.Entry.<Integer, Double>comparingByValue().reversed()
                        .thenComparing(Map.Entry.<Integer, Double>comparingByKey()))
                .mapToInt(Map.Entry::getKey)
                .toArray();
    }

    private Map<Integer, Integer> createUserCounterMap(int[] stages, int stageSize) {
        Map<Integer, Integer> usersOnStageMap = new HashMap<>();

        for (int stage = 1; stage <= stageSize; stage++) {
            usersOnStageMap.put(stage, 0);
        }

        for (int stage : stages) {
            usersOnStageMap.put(stage, usersOnStageMap.getOrDefault(stage, 0) + 1);
        }

        return usersOnStageMap;
    }

    private  Map<Integer, Double> createFailureRateMap(int N, Map<Integer, Integer> usersOnStageMap, int playersLeft) {
        Map<Integer, Double> failureRateOnStageMap = new HashMap<>();

        for (int stage = 1; stage <= N; stage++) {
            int usersOnStage = usersOnStageMap.get(stage);
            double failureRate = playersLeft != 0 ? (double) usersOnStage / playersLeft : 0;
            failureRateOnStageMap.put(stage, failureRate);
            playersLeft -= usersOnStage;
        }
        return failureRateOnStageMap;
    }
}
