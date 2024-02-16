package org.javaalgorithminterview.ch11_hash_table;

import java.util.HashSet;
import java.util.Set;

public class P31_2_Jewels_and_Stones {

    /**
     * The solution the book suggests
     */
    public int numJewelsInStones(String jewels, String stones) {

        int count = 0;

        Set<Character> jewelSet = new HashSet<>();

        for (char j : jewels.toCharArray()) {
            jewelSet.add(j);
        }

        for (char s : stones.toCharArray()) {
            if (jewelSet.contains(s)) {
                count += 1;
            }
        }
        return count;
    }

}
