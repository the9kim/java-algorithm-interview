package org.javaalgorithminterview.ch8_linked_list;

public class P18_1_Odd_Even_Linked_List {
    public static class ListNode {
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
     * 1. Link odd nodes and even nodes each at the same time.
     * 2. Link tail of odd linked list and head of even linked list.
     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }

        return linkNodes(head, head.next);
    }

    public ListNode linkNodes(ListNode oddHead, ListNode evenHead) {
        ListNode oddNode = oddHead;
        ListNode evenNode = evenHead;
        while (evenNode != null && evenNode.next != null) {
            oddNode.next = oddNode.next.next;
            evenNode.next = evenNode.next.next;

            oddNode = oddNode.next;
            evenNode = evenNode.next;
        }
        oddNode.next = evenHead;
        return oddHead;
    }

    /**
     * 1. Link odd nodes.
     * 2. Link even nodes.
     * 3. Link odd and even nodes.
     *
     * After linking odd nodes, all references are changed making it challenging to link subsequently even nodes.
     */
    public ListNode wrongOddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode oddHead = head;
        ListNode evenHead = head.next;

        ListNode oddNode = wrongLinkNodes(oddHead);
        ListNode evenNode = wrongLinkNodes(evenHead);

        while (oddNode.next != null) {
            oddNode = oddNode.next;
        }
        oddNode.next = evenNode;

        return head;
    }

    public ListNode wrongLinkNodes(ListNode head) {
        ListNode node = head;
        while (node.next != null && node.next.next != null) {
            node.next = node.next.next;
            node = node.next;
        }
        node.next = null;
        return head;
    }
}
