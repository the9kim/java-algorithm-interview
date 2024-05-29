package org.kakao18;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class P3_1_Cache {

    /**
     * 1. Crate a cache using a Deque
     * 2. Utilize for iteration and retrieve the cache
     * 3. Update the cache elements
     */

    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) {
            return 5 * cities.length;
        }

        int time = 0;

        // 1
        Queue<String> cache = new LinkedList<>();

        // 2 & 3
        for (String c : cities) {
            c = c.toLowerCase();

            // Cache hit
            if (cache.contains(c)) {
                time += 1;
                cache.remove(c);
                cache.add(c);
            // Cache miss
            } else {
                time += 5;
                if (cache.size() == cacheSize) {
                    cache.poll();
                }
                cache.add(c);
            }
        }
        return time;
    }
}
