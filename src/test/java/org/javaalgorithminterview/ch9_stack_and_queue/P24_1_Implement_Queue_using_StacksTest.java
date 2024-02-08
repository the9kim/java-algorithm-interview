package org.javaalgorithminterview.ch9_stack_and_queue;

import org.assertj.core.api.Assertions;
import org.javaalgorithminterview.ch9_stack_and_queue.P24_1_Implement_Queue_using_Stacks;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class P24_1_Implement_Queue_using_StacksTest {

    P24_1_Implement_Queue_using_Stacks p24;

    @BeforeEach
    void dummy() {
        p24 = new P24_1_Implement_Queue_using_Stacks();

        p24.push(1);
        p24.push(2);
        p24.push(3);
    }


    @Test
    void push() {
        Assertions.assertThat(p24.queue.size()).isEqualTo(3);
    }

    @Test
    void pop() {

        Assertions.assertThat(p24.pop()).isEqualTo(1);
    }

    @Test
    void peek() {
        Assertions.assertThat(p24.peek()).isEqualTo(1);
    }

    @Test
    void empty() {
        Assertions.assertThat(p24.empty()).isFalse();
    }


}
