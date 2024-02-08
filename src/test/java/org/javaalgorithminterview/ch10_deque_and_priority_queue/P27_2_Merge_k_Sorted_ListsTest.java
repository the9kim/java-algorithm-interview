package org.javaalgorithminterview.ch10_deque_and_priority_queue;

import org.assertj.core.api.SoftAssertions;
import org.javaalgorithminterview.ch10_deque_and_priority_queue.P27_2_Merge_k_Sorted_Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class P27_2_Merge_k_Sorted_ListsTest {

    P27_2_Merge_k_Sorted_Lists p26 = new P27_2_Merge_k_Sorted_Lists();
    P27_2_Merge_k_Sorted_Lists.ListNode head;
    P27_2_Merge_k_Sorted_Lists.ListNode node1;
    P27_2_Merge_k_Sorted_Lists.ListNode node2;
    P27_2_Merge_k_Sorted_Lists.ListNode node3;
    P27_2_Merge_k_Sorted_Lists.ListNode node4;
    P27_2_Merge_k_Sorted_Lists.ListNode node5;
    P27_2_Merge_k_Sorted_Lists.ListNode node6;
    P27_2_Merge_k_Sorted_Lists.ListNode node7;
    P27_2_Merge_k_Sorted_Lists.ListNode node8;



    @BeforeEach
    void setup() {
        p26 = new P27_2_Merge_k_Sorted_Lists();

        head = new P27_2_Merge_k_Sorted_Lists.ListNode();

        node1 = new P27_2_Merge_k_Sorted_Lists.ListNode(1);
        node2 = new P27_2_Merge_k_Sorted_Lists.ListNode(4);
        node3 = new P27_2_Merge_k_Sorted_Lists.ListNode(5);
        node4 = new P27_2_Merge_k_Sorted_Lists.ListNode(1);
        node5 = new P27_2_Merge_k_Sorted_Lists.ListNode(3);
        node6 = new P27_2_Merge_k_Sorted_Lists.ListNode(4);
        node7 = new P27_2_Merge_k_Sorted_Lists.ListNode(2);
        node8 = new P27_2_Merge_k_Sorted_Lists.ListNode(6);

        node1.next = node2;
        node2.next = node3;

        node4.next = node5;
        node5.next = node6;

        node7.next = node8;

    }

    @Test
    void mergeKSortedLists() {
        // given
        P27_2_Merge_k_Sorted_Lists.ListNode[] lists = {node1, node4, node7};

        // when
        P27_2_Merge_k_Sorted_Lists.ListNode listNode = p26.mergeKLists(lists);

        // then
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(listNode.val).isEqualTo(1);
            softly.assertThat(listNode.next.val).isEqualTo(1);
            softly.assertThat(listNode.next.next.val).isEqualTo(2);
        });

    }


}
