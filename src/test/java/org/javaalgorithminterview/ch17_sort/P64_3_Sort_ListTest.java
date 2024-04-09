package org.javaalgorithminterview.ch17_sort;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P64_3_Sort_ListTest {

    @Test
    void sortList() {
        // given
        P64_3_Sort_List.ListNode node5 = new P64_3_Sort_List.ListNode(0);
        P64_3_Sort_List.ListNode node4 = new P64_3_Sort_List.ListNode(4, node5);
        P64_3_Sort_List.ListNode node3 = new P64_3_Sort_List.ListNode(3, node4);
        P64_3_Sort_List.ListNode node2 = new P64_3_Sort_List.ListNode(5, node3);
        P64_3_Sort_List.ListNode node1 = new P64_3_Sort_List.ListNode(-1, node2);

        P64_3_Sort_List.ListNode expectedNode5 = new P64_3_Sort_List.ListNode(5);
        P64_3_Sort_List.ListNode expectedNode4 = new P64_3_Sort_List.ListNode(4, expectedNode5);
        P64_3_Sort_List.ListNode expectedNode3 = new P64_3_Sort_List.ListNode(3, expectedNode4);
        P64_3_Sort_List.ListNode expectedNode2 = new P64_3_Sort_List.ListNode(0, expectedNode3);
        P64_3_Sort_List.ListNode expectedNode1 = new P64_3_Sort_List.ListNode(-1, expectedNode2);

        // when
        P64_3_Sort_List p64 = new P64_3_Sort_List();
        P64_3_Sort_List.ListNode sortedList = p64.sortList(node1);

        // then
        P64_3_Sort_List.ListNode answer = sortedList;
        P64_3_Sort_List.ListNode expected = expectedNode1;
        while (answer != null && expected != null) {
            Assertions.assertThat(answer.val).isEqualTo(expected.val);
            answer = answer.next;
            expected = expected.next;
        }
    }

}
