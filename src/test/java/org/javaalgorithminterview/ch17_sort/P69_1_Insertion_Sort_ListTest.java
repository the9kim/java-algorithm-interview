package org.javaalgorithminterview.ch17_sort;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import static org.javaalgorithminterview.ch17_sort.P69_1_Insertion_Sort_List.*;
import static org.junit.jupiter.api.Assertions.*;

class P69_1_Insertion_Sort_ListTest {

    @Test
    void insertNode() {
        // given
        ListNode node4 = new ListNode(8);
        ListNode node3 = new ListNode(5, node4);
        ListNode node2 = new ListNode(3, node3);
        ListNode node1 = new ListNode(1, node2);

        ListNode insertionNode = new ListNode(4);

        ListNode expectedNode5 = new ListNode(8);
        ListNode expectedNode4 = new ListNode(5, expectedNode5);
        ListNode expectedNode3 = new ListNode(4, expectedNode4);
        ListNode expectedNode2 = new ListNode(3, expectedNode3);
        ListNode expectedNode1 = new ListNode(1, expectedNode2);

        // when
        P69_1_Insertion_Sort_List p69 = new P69_1_Insertion_Sort_List();
        ListNode answer = p69.insertNode(node1, insertionNode);

        // then
        while (answer != null && expectedNode1 != null) {
            System.out.println(answer.val);
            System.out.println(expectedNode1.val);
            Assertions.assertThat(answer.val).isEqualTo(expectedNode1.val);
            answer = answer.next;
            expectedNode1 = expectedNode1.next;
        }
    }

    @Test
    void insertionSortList() {
        // given
        ListNode node5 = new ListNode(4);
        ListNode node4 = new ListNode(5, node5);
        ListNode node3 = new ListNode(1, node4);
        ListNode node2 = new ListNode(8, node3);
        ListNode node1 = new ListNode(3, node2);

        ListNode expectedNode5 = new ListNode(8);
        ListNode expectedNode4 = new ListNode(5, expectedNode5);
        ListNode expectedNode3 = new ListNode(4, expectedNode4);
        ListNode expectedNode2 = new ListNode(3, expectedNode3);
        ListNode expectedNode1 = new ListNode(1, expectedNode2);

        // when
        P69_1_Insertion_Sort_List p69 = new P69_1_Insertion_Sort_List();
        ListNode answer = p69.insertionSortList(node1);

        // then
        while (answer != null && expectedNode1 != null) {

            Assertions.assertThat(answer.val).isEqualTo(expectedNode1.val);
            answer = answer.next;
            expectedNode1 = expectedNode1.next;
        }
    }
}
