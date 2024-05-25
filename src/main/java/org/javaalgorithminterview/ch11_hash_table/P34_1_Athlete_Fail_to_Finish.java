package org.javaalgorithminterview.ch11_hash_table;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class P34_1_Athlete_Fail_to_Finish {

    public String solution(String[] participant, String[] completion) {

        // 1. Create a map to includes participants
        Map<String, Deque<Boolean>> completed = new HashMap<>();
        for (String p : participant) {
            completed.putIfAbsent(p, new ArrayDeque<>());
            completed.get(p).add(false);
        }

        // 2. Check athletes to finish a race
        for (String c : completion) {
            Deque<Boolean> finished = completed.get(c);
            finished.poll();
            finished.add(true);
        }

        // 3. Check athletes failed to finish
        for (Map.Entry<String, Deque<Boolean>> entry : completed.entrySet()) {
            if (entry.getValue().contains(false)) {
                return entry.getKey();
            }
        }
        return null;
    }
}
