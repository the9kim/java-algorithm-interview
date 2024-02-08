package org.javaalgorithminterview.ch9_stack_and_queue;

import org.assertj.core.api.Assertions;
import org.javaalgorithminterview.ch9_stack_and_queue.P25_2_Design_Circular_Queue;
import org.junit.jupiter.api.Test;

class P25_2_Design_Circular_QueueTest {


    @Test
    void circularQueue() {
        // given
        P25_2_Design_Circular_Queue q = new P25_2_Design_Circular_Queue(5);

        // when
        q.enQueue(10);
        q.enQueue(20);
        q.enQueue(30);
        q.enQueue(40);
        q.deQueue();
        q.enQueue(50);
        q.deQueue();
        q.enQueue(60);


        // then
        Assertions.assertThat(q.len).isEqualTo(4);

    }
}
