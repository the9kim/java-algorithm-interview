package org.javaalgorithminterview.ch8_linked_list;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

class P19_2_Reverse_Linked_List2Test {

    @Test
    void reverseBetween() {
        //given
        P19_2_Reverse_Linked_List2.ListNode node5 = new P19_2_Reverse_Linked_List2.ListNode(5);
        P19_2_Reverse_Linked_List2.ListNode node4 = new P19_2_Reverse_Linked_List2.ListNode(4, node5);
        P19_2_Reverse_Linked_List2.ListNode node3 = new P19_2_Reverse_Linked_List2.ListNode(3, node4);
        P19_2_Reverse_Linked_List2.ListNode node2 = new P19_2_Reverse_Linked_List2.ListNode(2, node3);
        P19_2_Reverse_Linked_List2.ListNode node1 = new P19_2_Reverse_Linked_List2.ListNode(1, node2);

        // when
        P19_2_Reverse_Linked_List2 p20 = new P19_2_Reverse_Linked_List2();
        P19_2_Reverse_Linked_List2.ListNode reverse = p20.reverseBetween(node1, 2, 4);

        // then
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(reverse.val).isEqualTo(1);
            softly.assertThat(reverse.next.val).isEqualTo(4);
            softly.assertThat(reverse.next.next.val).isEqualTo(3);
            softly.assertThat(reverse.next.next.next.val).isEqualTo(2);
            softly.assertThat(reverse.next.next.next.next.val).isEqualTo(5);
        });

    }

}
