package org.javaalgorithminterview.ch8_linked_list;

public class P19_1_Reverse_Linked_List2 {

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

    /**
     * 1. Find the left and right nodes
     * 2. Revere a linked list between left and right nodes
     * 3. Link the given list with reversed one
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }

        ListNode root = new ListNode();
        root.next = head;

        ListNode leftNode = root;
        ListNode rightNode = root;

        // 1
        for (int i = 0; i < left - 1; i++) {
            leftNode = leftNode.next;
        }
        for (int i = 0; i < right; i++) {
            rightNode = rightNode.next;
        }

        // 2
        ListNode reverse = reverse(leftNode.next, rightNode);

        // 3
        leftNode.next = reverse;

        return root.next;
    }

    public ListNode reverse(ListNode leftNode, ListNode rightNode) {
        ListNode node = leftNode;
        ListNode end = rightNode.next;
        rightNode.next = null;
        ListNode rev = end;

        while (node != null) {
            ListNode next = node.next;
            node.next = rev;
            rev = node;
            node = next;
        }

        return rev;
    }
}
