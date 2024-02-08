package org.javaalgorithminterview.ch8_linked_list;

public class P15_2_Reverse_Linked_List {

    static class ListNode {
        int val;
        ListNode next;



        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * 1. Use Recursion with the next node as an input parameter
     * 2. Switch the current node with the previous node.
     */
    public ListNode reverseList(ListNode head) {
        return reverse(null, head);
    }

    public ListNode reverse(ListNode prev, ListNode node) {
        if (node == null) {
            return prev;
        }

        ListNode next = node.next;
        node.next = prev;

        return reverse(node, next);
    }
}
