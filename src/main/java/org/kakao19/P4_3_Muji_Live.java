package org.kakao19;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class P4_3_Muji_Live {

    public int solution(int[] food_times, long k) {
        Map<Integer, Integer> foodTimeMap = new HashMap<>();

        // Create a map of food index and its corresponding time
        for (int i = 0; i < food_times.length; i++) {
            int time = food_times[i];
            foodTimeMap.put(i + 1, time);
        }

        // Sort the food items by their times in ascending order
        LinkedList<Map.Entry<Integer, Integer>> sortedFoodTime =
                foodTimeMap.entrySet()
                        .stream()
                        .sorted(Map.Entry.comparingByValue())
                        .collect(Collectors.toCollection(LinkedList::new));

        long prevHeight = 0;

        // Process the sorted food items
        while (!sortedFoodTime.isEmpty()) {
            int foodHeight = sortedFoodTime.peek().getValue();
            int foodCount = sortedFoodTime.size();

            // Calculate time for this level of food (check overflow by casting)
            long timeForCurrentLevel = (foodHeight - prevHeight) * foodCount;

            if (timeForCurrentLevel <= k) {
                k -= timeForCurrentLevel;
                prevHeight = foodHeight;
                sortedFoodTime.poll();  // Remove the processed food item
            } else {
                // Sort remaining food items by their original index
                List<Map.Entry<Integer, Integer>> remainingFood = sortedFoodTime.stream()
                        .sorted(Map.Entry.comparingByKey())
                        .collect(Collectors.toList());

                // Return the next food item to be eaten
                return remainingFood.get((int) (k % remainingFood.size())).getKey();
            }
        }

        // If no food remains to be processed
        return -1;
    }
}
