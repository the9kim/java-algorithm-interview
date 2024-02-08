package org.javaalgorithminterview.ch8_linked_list;

public class P17_1_Swap_Nodes_in_Pairs {

    static class ListNode {
        int val;
        ListNode next;

    }

    public ListNode swapPairs(ListNode head) {

        ListNode root = new ListNode();
        ListNode node = root;
        node.next = head;

        while (node.next != null && node.next.next != null) {
            ListNode a = node.next;
            ListNode b = node.next.next;

            a.next = b.next;
            node.next = b;
            node.next.next = a;
            node = node.next.next;
        }

        return root.next;
    }

    /**
     * In this case, I can't handle input that has an odd number of nodes.
     */
    public ListNode swapPairs2(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode answer = head.next;

        ListNode prev = head;
        ListNode node = head.next;
        ListNode next = head.next.next;

        while (prev != null && node != null && next != null) {
            prev.next = next.next;
            node.next = prev;

            prev = next;
            node = next.next;
            next = next.next.next;

        }
        prev.next = next;
        node.next = prev;

        return answer;
    }
}
