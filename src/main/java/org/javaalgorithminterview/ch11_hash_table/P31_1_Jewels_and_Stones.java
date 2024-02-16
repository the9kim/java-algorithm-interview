package org.javaalgorithminterview.ch11_hash_table;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class P31_1_Jewels_and_Stones {

    /**
     * 1. Count occurrence of each character in the String 'stones' and create a hash map.
     * 2. Verify if every key in the hash map is present in the String jewels.
     * 3. Sum the values in the hash map corresponding to the keys found in 'jewels'.
     */
    public int numJewelsInStones(String jewels, String stones) {
        int answer = 0;

        // 1
        Map<Character, Integer> counter = new HashMap<>();

        for (char stone : stones.toCharArray()) {
            counter.put(stone, counter.getOrDefault(stone, 0) + 1);
        }

        List<Character> jewelList = jewels.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList());


        // 2 & 3
        for (HashMap.Entry<Character, Integer> entry : counter.entrySet()) {
            if (jewelList.contains(entry.getKey())) {
                answer += entry.getValue();
            }
        }

        return answer;
    }

    /**
     * The solution the book suggests
     */
    public int numJewelsInStones2(String jewels, String stones) {
        int count = 0;

        Map<Character, Integer> freqs = new HashMap<>();

        // 1
        for (char s : stones.toCharArray()) {
            freqs.put(s, freqs.getOrDefault(s, 0) + 1);
        }

        // 2 & 3
        for (char j : jewels.toCharArray()) {
            if (freqs.containsKey(j)) {
                count += freqs.get(j);
            }
        }
        return count;
    }
}
