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
        ListNode node = root;

        while (node != null && node.next != null) {
            ListNode a = node.next;
            ListNode b = node.next.next;

            if (b != null) {
                node.next = b;
                a.next = b.next;
                b.next = a;
            } else {
                node.next = a;
            }
            node = a;
        }

        return root.next;
    }
}
