package org.javaalgorithminterview.ch10_deque_and_priority_queue;

import org.assertj.core.api.SoftAssertions;
import org.javaalgorithminterview.ch10_deque_and_priority_queue.P26_1_Design_Circular_Deque;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class P26_1_Design_Circular_DequeTest {

    P26_1_Design_Circular_Deque p26;

    @BeforeEach
    void setUp() {
        p26 = new P26_1_Design_Circular_Deque(5);

        p26.insertLast(2);
        p26.insertFront(1);
    }

    @Test
    void insertLast() {
        // given & when
        boolean answer = p26.insertLast(3);

        // then
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(answer).isEqualTo(true);
            softly.assertThat(p26.length).isEqualTo(3);
            softly.assertThat(p26.rear).isEqualTo(1);
        });
    }

    @Test
    void insertFront() {
        // given & when
        boolean answer = p26.insertFront(0);

        // then
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(answer).isEqualTo(true);
            softly.assertThat(p26.length).isEqualTo(3);
            softly.assertThat(p26.front).isEqualTo(3);
        });
    }

    @Test
    void deleteFront() {
        // given & when
        boolean answer = p26.deleteFront();

        // then
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(answer).isTrue();
            softly.assertThat(p26.front).isEqualTo(0);
            softly.assertThat(p26.length).isEqualTo(1);
        });
    }

    @Test
    void deleteLast() {

        // given & then
        boolean answer = p26.deleteLast();

        // then
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(answer).isTrue();
            softly.assertThat(p26.rear).isEqualTo(4);
            softly.assertThat(p26.length).isEqualTo(1);
        });
    }

    @Test
    void getFront() {
        // given
        int expected = 1;

        // then
        int answer = p26.getFront();

        // then
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(answer).isEqualTo(expected);
        });
    }

    @Test
    void getRear() {
        // given
        int expected = 2;

        // then
        int answer = p26.getRear();

        // then
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(answer).isEqualTo(expected);
        });
    }
}
