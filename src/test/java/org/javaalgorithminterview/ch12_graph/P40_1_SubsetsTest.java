package org.javaalgorithminterview.ch12_graph;

import org.junit.jupiter.api.Test;

import java.util.List;

class P40_1_SubsetsTest {

    @Test
    void subsets() {
        // given
        P40_1_Subsets p40 = new P40_1_Subsets();

        // when
        List<List<Integer>> subsets = p40.subsets(new int[]{1, 2, 3});

        // then
        System.out.println(subsets);
    }
}
