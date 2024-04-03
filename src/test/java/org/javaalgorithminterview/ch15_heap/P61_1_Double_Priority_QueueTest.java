package org.javaalgorithminterview.ch15_heap;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class P61_1_Double_Priority_QueueTest {


    P61_1_Double_Priority_Queue.BinaryHeap heap;

    @BeforeEach
    void setUp() {
        heap = new P61_1_Double_Priority_Queue.BinaryHeap();
        Integer[] input = {1, 2, 3, 4, 5};

        for (Integer i : input) {
            heap.insert(i);
        }
    }

    @Test
    void solution1() {
        // given
        String[] operations = new String[]{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
        P61_1_Double_Priority_Queue p61 = new P61_1_Double_Priority_Queue();

        int[] expected = new int[]{333, -45};

        // when

        int[] answer = p61.solution(operations);

        // then
        assertThat(answer).isEqualTo(expected);
    }

    @Test
    void solution2() {
        // given
        String[] operations = new String[]{"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
        P61_1_Double_Priority_Queue p61 = new P61_1_Double_Priority_Queue();

        int[] expected = new int[]{0, 0};

        // when

        int[] answer = p61.solution(operations);

        // then
        assertThat(answer).isEqualTo(expected);
    }


    @Test
    void insert() {
        // given
        List<Integer> minExpected = Arrays.asList(null, 1, 2, 3, 4, 5);
        List<Integer> maxExpected = Arrays.asList(null, 5, 4, 2, 1, 3);

        // when & then
        assertThat(heap.minElems).isEqualTo(minExpected);
        assertThat(heap.maxElems).isEqualTo(maxExpected);
    }


    @Test
    void extractMin() {
        // given
        List<Integer> minExpected = Arrays.asList(null, 2, 4, 3, 5);
        List<Integer> maxExpected = Arrays.asList(null, 5, 4, 2, 3);

        // when
        heap.extractMin();

        // then
        assertThat(heap.minElems).isEqualTo(minExpected);
        assertThat(heap.maxElems).isEqualTo(maxExpected);
    }

    @Test
    void extractMax() {
        // given
        List<Integer> minExpected = Arrays.asList(null, 1, 2, 3, 4);
        List<Integer> maxExpected = Arrays.asList(null, 4, 3, 2, 1);

        // when
        heap.extractMax();

        // then
        assertThat(heap.minElems).isEqualTo(minExpected);
        assertThat(heap.maxElems).isEqualTo(maxExpected);
    }
}
