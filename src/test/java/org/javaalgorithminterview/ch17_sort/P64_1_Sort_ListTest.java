package org.javaalgorithminterview.ch17_sort;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.javaalgorithminterview.ch17_sort.P64_1_Sort_List.*;

class P64_1_Sort_ListTest {

    @Test
    void sortList() {
        // given
        ListNode node5 = new ListNode(0);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(5, node3);
        ListNode node1 = new ListNode(-1, node2);

        ListNode expectedNode5 = new ListNode(5);
        ListNode expectedNode4 = new ListNode(4, expectedNode5);
        ListNode expectedNode3 = new ListNode(3, expectedNode4);
        ListNode expectedNode2 = new ListNode(0, expectedNode3);
        ListNode expectedNode1 = new ListNode(-1, expectedNode2);

        // when
        P64_1_Sort_List p64 = new P64_1_Sort_List();
        ListNode sortedList = p64.sortList(node1);

        // then
        ListNode answer = sortedList;
        ListNode expected = expectedNode1;
        while (answer != null && expected != null) {
            Assertions.assertThat(answer.val).isEqualTo(expected.val);
            answer = answer.next;
            expected = expected.next;
        }
    }
}
