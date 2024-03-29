package org.javaalgorithminterview.ch15_heap;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class BinaryHeapTest {

    @Test
    void insertHeap() {
        // given
        List<Integer> elems = new ArrayList<>(Arrays.asList(null, 5, 9, 11, 14, 18, 19, 21, 33, 17, 27));
        List<Integer> expected = Arrays.asList(null, 2, 5, 11, 14, 9, 19, 21, 33, 17, 27, 18);
        Integer k = 2;

        // when
        BinaryHeap binaryHeap = new BinaryHeap(elems);
        binaryHeap.insert(k);

        // then
        System.out.println(binaryHeap.elems);
        assertThat(binaryHeap.elems.get(1)).isEqualTo(k);
        assertThat(binaryHeap.elems).isEqualTo(expected);
    }

    @Test
    void extract() {
        // given
        List<Integer> elems = new ArrayList<>(Arrays.asList(null, 5, 9, 11, 14, 18, 19, 21, 33, 17, 27));
        List<Integer> expectedElems = Arrays.asList(null, 9, 11, 14, 18, 19 , 21, 33, 17, 27);
        Integer expected = 5;

        // when
        BinaryHeap binaryHeap = new BinaryHeap(elems);
        int extracted = binaryHeap.extract();

        // then
        System.out.println(binaryHeap.elems);
        assertThat(extracted).isEqualTo(expected);
        assertThat(binaryHeap.elems).isEqualTo(expectedElems);
    }

    @Test
    void swap() {
        // given
        List<Integer> elems = new ArrayList<>(Arrays.asList(null, 10, 20));
        List<Integer> expected = Arrays.asList(null, 20, 10);

        // when
        BinaryHeap binaryHeap = new BinaryHeap(elems);
        binaryHeap.swap(1, 2);

        // then
        assertThat(binaryHeap.elems).isEqualTo(expected);
    }
}
