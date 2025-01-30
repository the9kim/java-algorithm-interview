package org.javaalgorithminterview.ch11_hash_table;

import java.util.HashMap;
import java.util.Map;

public class P31_1_Jewels_and_Stones {

    public int numJewelsInStones(String jewels, String stones) {
        Map<Character, Integer> stoneMap = new HashMap<>();

        for (char s : stones.toCharArray()) {
            stoneMap.put(s, stoneMap.getOrDefault(s, 0) + 1);
        }

        int answer = 0;

        for (char j : jewels.toCharArray()) {
            if (stoneMap.containsKey(j)) {
                answer += stoneMap.get(j);
            }
        }

        return answer;
    }
}
