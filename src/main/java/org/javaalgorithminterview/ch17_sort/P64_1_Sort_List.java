package org.javaalgorithminterview.ch17_sort;

public class P64_1_Sort_List {

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

    public ListNode sortList(ListNode head) {
        // 1
        ListNode node = head;
        int len = 0;

        while (node != null) {
            len++;
            node = node.next;
        }

        if (len <= 1) {
            return head;
        }

        // 2.
        ListNode left = head;
        ListNode right;

        for (int i = 0; i < (len / 2) - 1; i++) {
            left = left.next;
        }
        right = left.next;
        left.next = null;
        left = head;


        // 3.
        ListNode sortedLeft = sortList(left);
        ListNode sortedRight = sortList(right);

        ListNode root = new ListNode(null);
        root.next = sortedLeft;
        ListNode prevLeft = root;


        // 4.
        while (sortedRight != null) {
            while (sortedLeft != null && sortedLeft.val <= sortedRight.val) {
                prevLeft = prevLeft.next;
                sortedLeft = sortedLeft.next;
            }
            ListNode temp = sortedRight.next;
            sortedRight.next = sortedLeft;
            prevLeft.next = sortedRight;
            prevLeft = sortedRight;
            sortedRight = temp;
        }

        return root.next;
    }
}
