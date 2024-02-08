package org.javaalgorithminterview.ch8_linked_list;

import org.javaalgorithminterview.ch8_linked_list.P15_2_Reverse_Linked_List;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.SoftAssertions;

class P15_2_Reverse_Linked_ListTest {

    @Test
    void reverseNode() {

        // given
        P15_2_Reverse_Linked_List.ListNode node2 = new P15_2_Reverse_Linked_List.ListNode(2);
        P15_2_Reverse_Linked_List.ListNode node1 = new P15_2_Reverse_Linked_List.ListNode(1, node2);

        P15_2_Reverse_Linked_List p15 = new P15_2_Reverse_Linked_List();

        // when
        P15_2_Reverse_Linked_List.ListNode answer = p15.reverseList(node1);


        // then
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(answer.val).isEqualTo(2);
            softly.assertThat(answer.next.val).isEqualTo(1);
        });
    }
}
