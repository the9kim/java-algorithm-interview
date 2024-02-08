package org.javaalgorithminterview.ch9_stack_and_queue;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.javaalgorithminterview.ch9_stack_and_queue.P23_1_Implement_Stack_using_Queues;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class P23_1_Implement_Stack_using_QueuesTest {

    P23_1_Implement_Stack_using_Queues p23;

    @BeforeEach
    void init() {
        p23 = new P23_1_Implement_Stack_using_Queues();
        p23.push(0);
        p23.push(1);
        p23.push(2);
    }

    @Test
    void push() {
        // then
        Assertions.assertThat(p23.stack.size()).isEqualTo(3);
    }

    @Test
    void pop() {
        // given
        int expected = 2;

        // when
        int val = p23.pop();

        // then
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(val).isEqualTo(expected);
            softly.assertThat(p23.stack.size() == 2);
        });
    }


    @Test
    void top() {
        // given
        int expected = 2;
        // when
        int val = p23.top();

        // then
        Assertions.assertThat(val).isEqualTo(expected);
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(p23.stack.size() == 3);
        });
    }

    @Test
    void empty() {
        // given
        P23_1_Implement_Stack_using_Queues p23 = new P23_1_Implement_Stack_using_Queues();

        // when
        boolean isEmpty = p23.empty();

        // then
        Assertions.assertThat(isEmpty).isTrue();
    }
}
