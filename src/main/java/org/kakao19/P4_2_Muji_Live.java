package org.kakao19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class P4_2_Muji_Live {

    static class Food {
        int time;
        int index;

        public Food(int time, int index) {
            this.time = time;
            this.index = index;
        }
    }

    /**
     * A problem designed to assess skills in type casting.

       1. Convert the input Array to a List and Sort it in acsending order of values
       2. Calculate the difference between the current index and the previous index in the list, multiply that difference by the length from the current index to the end of the list, and then subtract the resulting value from k.
       3. Order the input list in ascending order by index and Find the answer
     */
    public int solution(int[] food_times, long k) {

        // 1.
        List<Food> foods = new ArrayList<>();

        for (int i = 0; i < food_times.length; i++) {
            foods.add(new Food(food_times[i], i + 1));
        }

        Collections.sort(foods, Comparator.comparingInt(f -> f.time));

        // 2.
        int n = food_times.length;
        int preTime = 0;
        int idx = 0;

        for (Food f : foods) {
            long diff = f.time - preTime;
            if (diff > 0) {
                long spending = diff * n;
                if (k >= spending) {
                    k -= spending;
                    preTime = f.time;
                } else {
                    k %= n;
                    foods.subList(idx, foods.size()).sort(Comparator.comparingInt(t -> t.index));
                    return foods.get(idx + (int) k).index;
                }

            }
            idx++;
            n--;
        }

        return -1;
    }
}
