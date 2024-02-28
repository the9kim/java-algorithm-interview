package org.javaalgorithminterview.ch12_graph;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class P38_1_CombinationsTest {

    @Test
    void combine() {
        // given
        int n = 4;
        int k = 2;

        // when
        P38_1_Combinations p38 = new P38_1_Combinations();
        List<List<Integer>> result = p38.combine(n, k);

        // then
        System.out.println(result);
    }

    @Test
    void combine2() {
        // given
        int n = 5;
        int k = 3;

        // when
        P38_1_Combinations p38 = new P38_1_Combinations();
        List<List<Integer>> result = p38.combine(n, k);

        // then
        System.out.println(result);
    }
}
