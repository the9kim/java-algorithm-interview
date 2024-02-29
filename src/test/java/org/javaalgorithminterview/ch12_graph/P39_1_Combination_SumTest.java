package org.javaalgorithminterview.ch12_graph;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class P39_1_Combination_SumTest {

    @Test
    void combinationSum() {
        // given
        int [] candidates = {2,3,6,7};
        int target = 7;

        // when
        P39_1_Combination_Sum p39 = new P39_1_Combination_Sum();
        List<List<Integer>> answer = p39.combinationSum(candidates, target);

        // then
        System.out.println(answer);
    }
}
