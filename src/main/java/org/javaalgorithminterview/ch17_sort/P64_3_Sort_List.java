package org.javaalgorithminterview.ch17_sort;

/**
 * Quick Sort
 */
public class P64_3_Sort_List {

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

    public void quickSort(ListNode head, ListNode tail) {
        if (head == tail) {
            return;
        }
        ListNode pivot = head;

        ListNode left = head;
        ListNode right = head.next;

        while (right != tail) {
            if (right.val < pivot.val) {
                // Move the left to the next
                left = left.next;

                // Swap the left and the right
                int temp = left.val;
                left.val = right.val;
                right.val = temp;
            }
            // Move the right to the next
            right = right.next;
        }

        // Swap the head and the left
        int temp = head.val;
        head.val = left.val;
        left.val = temp;

        quickSort(head, left);
        quickSort(left.next, tail);
    }

    public ListNode sortList(ListNode head) {
        quickSort(head, null);
        return head;
    }
}
