package org.javaalgorithminterview.ch17_sort;

/**
 * Merge Sort
 */
public class P64_2_Sort_List {

    static class ListNode {
        Integer val;
        ListNode next;

        ListNode(Integer val) {
            this.val = val;
        }

        public ListNode(Integer val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeTwoLists(ListNode left, ListNode right) {
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }

        if (left.val > right.val) {
            ListNode temp = left;
            left = right;
            right = temp;
        }

        left.next = mergeTwoLists(left.next, right);

        return left;
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode half = null;

        while (fast != null && fast.next != null) {
            half = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        half.next= null;

        ListNode left = sortList(head);
        ListNode right = sortList(slow);

        return mergeTwoLists(left, right);
    }
}
