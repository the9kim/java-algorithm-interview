package org.javaalgorithminterview.ch18_binary_search;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class P72_1_Intersection_of_Two_ArraysTest {

    @Test
    void intersection() {
        // given
        int[] nums1 = new int[]{4, 9, 5};
        int[] nums2 = new int[]{9, 4, 9, 8, 4, 6};

        int[] expected = new int[]{4, 9};

        // when
        P72_1_Intersection_of_Two_Arrays p72 = new P72_1_Intersection_of_Two_Arrays();
        int[] answer = p72.intersection(nums1, nums2);

        // then
        assertThat(answer).isEqualTo(expected);
    }

    @Test
    void intersection2_when_input_arrays_same_size() {
        // given
        int[] nums1 = new int[]{3};
        int[] nums2 = new int[]{1};

        int[] expected = new int[]{};

        // when
        P72_1_Intersection_of_Two_Arrays p72 = new P72_1_Intersection_of_Two_Arrays();
        int[] answer = p72.intersection(nums1, nums2);

        // then
        assertThat(answer).isEqualTo(expected);
    }
}
