package org.javaalgorithminterview.ch17_sort;

public class P69_3_Insertion_Sort_List {

    public static class ListNode {
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
     * The book solution
     *
     * It enhances the condition for initializing the pointer of the sorted list.
     */
    public ListNode insertionSortList(ListNode head) {
        ListNode parent = new ListNode();
        ListNode p = parent;

        while (head != null) {
            while (p.next != null && p.next.val < head.val) {
                p = p.next;
            }
            ListNode pNext = p.next;
            ListNode headNext = head.next;

            p.next = head;
            head.next = pNext;
            head = headNext;

            if (head != null && p.val < head.val) {
                p = parent;
            }
        }
        return parent.next;
    }
}
