package org.javaalgorithminterview.ch8_linked_list;

import org.assertj.core.api.SoftAssertions;
import org.javaalgorithminterview.ch8_linked_list.P16_1_Add_Two_Numbers;
import org.junit.jupiter.api.Test;

class P16_1_Add_Two_NumbersTest {

    @Test
    void addTwoNumbers() {
        // given
        P16_1_Add_Two_Numbers.ListNode listNode3 = new P16_1_Add_Two_Numbers.ListNode(3);
        P16_1_Add_Two_Numbers.ListNode listNode2 = new P16_1_Add_Two_Numbers.ListNode(4, listNode3);
        P16_1_Add_Two_Numbers.ListNode listNode1 = new P16_1_Add_Two_Numbers.ListNode(2, listNode2);

        P16_1_Add_Two_Numbers.ListNode listNode6 = new P16_1_Add_Two_Numbers.ListNode(4);
        P16_1_Add_Two_Numbers.ListNode listNode5 = new P16_1_Add_Two_Numbers.ListNode(6, listNode6);
        P16_1_Add_Two_Numbers.ListNode listNode4 = new P16_1_Add_Two_Numbers.ListNode(5, listNode5);


        // when
        P16_1_Add_Two_Numbers p16 = new P16_1_Add_Two_Numbers();
        P16_1_Add_Two_Numbers.ListNode answer = p16.addTwoNumbers(listNode1, listNode4);

        P16_1_Add_Two_Numbers.ListNode temp = answer;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }

        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(answer.val).isEqualTo(7);
            softly.assertThat(answer.next.val).isEqualTo(0);
            softly.assertThat(answer.next.next.val).isEqualTo(8);
        });
    }

    @Test
    void addTwoNumbers2() {
        // given
        P16_1_Add_Two_Numbers.ListNode listNode2 = new P16_1_Add_Two_Numbers.ListNode(7);
        P16_1_Add_Two_Numbers.ListNode listNode1 = new P16_1_Add_Two_Numbers.ListNode(3, listNode2);

        P16_1_Add_Two_Numbers.ListNode listNode4 = new P16_1_Add_Two_Numbers.ListNode(2);
        P16_1_Add_Two_Numbers.ListNode listNode3 = new P16_1_Add_Two_Numbers.ListNode(9, listNode4);


        // when
        P16_1_Add_Two_Numbers p16 = new P16_1_Add_Two_Numbers();
        P16_1_Add_Two_Numbers.ListNode answer = p16.addTwoNumbers(listNode1, listNode3);

        P16_1_Add_Two_Numbers.ListNode temp = answer;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }

        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(answer.val).isEqualTo(2);
            softly.assertThat(answer.next.val).isEqualTo(0);
            softly.assertThat(answer.next.next.val).isEqualTo(1);
        });
    }
}
