package org.kakao19;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class P4_1_Muji_Live {

    public int solution(int[] food_times, long k) {
        List<Integer> times = Arrays.stream(food_times)
                .boxed()
                .collect(Collectors.toList());

        int cycleSum = 0;
        long count = k;

        while (count > (Collections.min(times) - cycleSum) * times.size()) {
            if (times.size() == 0) {
                return -1;
            }
            int min = Collections.min(times);
            int diff = min - cycleSum;
            cycleSum = min;
            count -= diff * times.size();
            times.remove((Integer) min);
        }

        int idx = 0;
        while (count >= 0) {
            while (food_times[idx % food_times.length] <= cycleSum) {
                idx++;
            }
            count--;
            idx++;
        }
        return (idx - 1) % food_times.length + 1;
    }
}
