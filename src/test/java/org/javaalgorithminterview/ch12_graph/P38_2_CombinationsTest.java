package org.javaalgorithminterview.ch12_graph;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class P38_2_CombinationsTest {
    @Test
    void combine() {
        // given
        int n = 4;
        int k = 2;

        // when
        P38_2_Combinations p38 = new P38_2_Combinations();
        List<List<Integer>> result = p38.combine(n, k);

        // then
        System.out.println(result);
    }

}
