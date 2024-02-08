package org.javaalgorithminterview.ch8_linked_list;

public class P17_2_Swap_Nodes_in_Pairs {

    static class ListNode {
        int val;
        ListNode next;

    }

    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = head;
        ListNode node = head.next;
        ListNode next = head.next.next;

        node.next = prev;

        prev.next = swapPairs(next);
        return node;
    }
}
