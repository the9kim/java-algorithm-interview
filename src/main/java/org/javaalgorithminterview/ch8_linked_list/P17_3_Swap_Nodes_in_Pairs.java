package org.javaalgorithminterview.ch8_linked_list;

public class P17_3_Swap_Nodes_in_Pairs {

    static class ListNode {
        int val;
        ListNode next;

    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode root = new ListNode();
        root.next = head;
        ListNode prev = root;

        while (prev != null && prev.next != null) {
            ListNode node = prev.next;
            ListNode next = prev.next.next;

            if (next != null) {
                prev.next = next;
                node.next = next.next;
                next.next = node;
            }
            prev = node;
        }

        return root.next;
    }
}
