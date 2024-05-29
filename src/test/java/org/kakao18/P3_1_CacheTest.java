package org.kakao18;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P3_1_CacheTest {

    @Test
    void cache() {
        // given
        String[] cities = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};
        int cacheSize = 3;
        int expected = 21;

        // when
        P3_1_Cache p3 = new P3_1_Cache();
        int answer = p3.solution(cacheSize, cities);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }

    @Test
    void cache2() {
        // given
        String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        int cacheSize = 3;
        int expected = 50;

        // when
        P3_1_Cache p3 = new P3_1_Cache();
        int answer = p3.solution(cacheSize, cities);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }

    @Test
    void cache3() {
        // given
        String[] cities = {"Jeju", "Pangyo", "NewYork", "newyork"};
        int cacheSize = 2;
        int expected = 16;

        // when
        P3_1_Cache p3 = new P3_1_Cache();
        int answer = p3.solution(cacheSize, cities);

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }



}
