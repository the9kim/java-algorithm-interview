package org.javaalgorithminterview.ch12_graph;

import org.junit.jupiter.api.Test;

import java.util.List;

class P37_2_PermutationsTest {

    @Test
    void permute() {
        // given
        int[] nums = {1, 2, 3};

        // when
        P37_2_Permutations p37 = new P37_2_Permutations();
        List<List<Integer>> answer = p37.permute(nums);

        // then
        System.out.println(answer);
    }

    @Test
    void permute2() {
        // given
        int[] nums = {0, 1};

        // when
        P37_2_Permutations p37 = new P37_2_Permutations();
        List<List<Integer>> answer = p37.permute(nums);

        // then
        System.out.println(answer);
    }


}
