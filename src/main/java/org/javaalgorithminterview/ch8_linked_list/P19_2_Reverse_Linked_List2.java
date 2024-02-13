package org.javaalgorithminterview.ch8_linked_list;

public class P19_2_Reverse_Linked_List2 {
    static class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) {
            return null;
        }

        ListNode root = new ListNode();
        root.next = head;

        ListNode startNode = root;
        for (int i = 0; i < left - 1; i++) {
            startNode = startNode.next;
        }
        ListNode leftNode = startNode.next;


        for (int i = 0; i < right - left; i++) {
            ListNode rightNode = leftNode.next;
            leftNode.next = rightNode.next;
            rightNode.next = startNode.next;
            startNode.next = rightNode;
        }

        return root.next;
    }

    /**
     * The answer the book suggests
     */
    public ListNode  reverseBetween2(ListNode head, int left , int right) {
        if (head == null) {
            return null;
        }

        ListNode root = new ListNode();
        root.next = head;

        ListNode start = root;
        for (int i = 0; i < left - 1; i++) {
            start = start.next;
        }

        ListNode end = start.next;
        for (int i = 0; i < right - left; i++) {
            ListNode temp = start.next;
            start.next = end.next;
            end.next = end.next.next;
            start.next.next = temp;
        }

        return root.next;
    }
}
