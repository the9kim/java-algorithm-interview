package org.javaalgorithminterview.ch17_sort;

public class P69_2_Insertion_Sort_List {

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
     * This method identifies the location immediately before where the target node is inserted within the sorted list
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
            p = parent;
        }
        return parent.next;
    }
}
