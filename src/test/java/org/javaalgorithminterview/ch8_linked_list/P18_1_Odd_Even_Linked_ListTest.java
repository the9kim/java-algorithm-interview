package org.javaalgorithminterview.ch8_linked_list;

import org.javaalgorithminterview.ch8_linked_list.P18_1_Odd_Even_Linked_List;
import org.junit.jupiter.api.Test;

class P18_1_Odd_Even_Linked_ListTest {

    @Test
    void oddEvenList() {
        // given
        P18_1_Odd_Even_Linked_List.ListNode node6 = new P18_1_Odd_Even_Linked_List.ListNode(6);
        P18_1_Odd_Even_Linked_List.ListNode node5 = new P18_1_Odd_Even_Linked_List.ListNode(5, node6);
        P18_1_Odd_Even_Linked_List.ListNode node4 = new P18_1_Odd_Even_Linked_List.ListNode(4, node5);
        P18_1_Odd_Even_Linked_List.ListNode node3 = new P18_1_Odd_Even_Linked_List.ListNode(3, node4);
        P18_1_Odd_Even_Linked_List.ListNode node2 = new P18_1_Odd_Even_Linked_List.ListNode(2, node3);
        P18_1_Odd_Even_Linked_List.ListNode node1 = new P18_1_Odd_Even_Linked_List.ListNode(1, node2);

        // when
        P18_1_Odd_Even_Linked_List p18 = new P18_1_Odd_Even_Linked_List();
        P18_1_Odd_Even_Linked_List.ListNode answer = p18.oddEvenList(node1);

        // then
        while (answer != null) {
            System.out.println(answer.val);
            answer = answer.next;
        }
    }
}
