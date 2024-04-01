package org.javaalgorithminterview.ch15_heap;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;

class P60_2_Kth_Largest_Element_inArrayTest {

    @Test
    void findKthLargest() {
        // given
        int[] nums = new int[]{3, 2, 1, 5, 6, 4};
        int k = 2;

        P60_2_Kth_Largest_Element_inArray p60 = new P60_2_Kth_Largest_Element_inArray();
        int expected = 5;

        // when
        int kthLargest = p60.findKthLargest(nums, k);

        // then
        assertThat(kthLargest).isEqualTo(expected);
    }

    @Test
    void insert() {
        // given
        int[] input = new int[]{2, 1, 4, 3};

        P60_2_Kth_Largest_Element_inArray.BinaryHeap heap = new P60_2_Kth_Largest_Element_inArray.BinaryHeap(new ArrayList<>());
        List<Integer> expected = Arrays.asList(null, 4, 3, 2, 1);

        // when
        for (int e : input) {
            heap.insert(e);
        }

        // then
        System.out.println(heap.elems);
        assertThat(heap.elems).isEqualTo(expected);
    }

    @Test
    void extract() {

        // given
        int[] input = new int[]{2, 1, 4, 3};

        P60_2_Kth_Largest_Element_inArray.BinaryHeap heap = new P60_2_Kth_Largest_Element_inArray.BinaryHeap(new ArrayList<>());
        int expected = 4;

        // when
        for (int e : input) {
            heap.insert(e);
        }

        int extracted = heap.extract();

        // then
        System.out.println(extracted);
        assertThat(extracted).isEqualTo(expected);
    }
}
