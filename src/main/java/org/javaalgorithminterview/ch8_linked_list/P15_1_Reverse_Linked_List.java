package org.javaalgorithminterview.ch8_linked_list;

public class P15_1_Reverse_Linked_List {

    static class ListNode {
        int val;
        ListNode next;
    }

    /**
     * 1. Utilize a while roof of the head node
     * 2. Add the node to a reversed node during the roof
     */
    public ListNode reverseList(ListNode head) {
        ListNode temp = head;
        ListNode rev = null;
        // 1
        while (temp != null) {
            // 2
            ListNode next = temp.next;
            temp.next = rev;
            rev = temp;
            temp = next;
        }

        return rev;
    }
}
