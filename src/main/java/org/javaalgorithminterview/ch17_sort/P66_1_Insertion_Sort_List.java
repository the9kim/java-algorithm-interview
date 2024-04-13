package org.javaalgorithminterview.ch17_sort;

public class P66_1_Insertion_Sort_List {

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
    public ListNode insertNode(ListNode sorted, ListNode targetNode) {
        // If a node is inserted for the first time, return the node as a sorted list
        if (sorted == null) {
            return targetNode;
        }

        ListNode prev = new ListNode(-1);
        prev.next = sorted;
        ListNode current = sorted;

        // Move the node to find the location for insertion
        while (current != null && current.val < targetNode.val) {
            prev = current;
            current = current.next;
        }
        // Insert the target node
        prev.next = targetNode;
        targetNode.next = current;

        // Just in case target node is inserted at the front
        if (targetNode.next != null && targetNode.next.equals(sorted)) {
            return targetNode;
        }
        return sorted;
    }

    public ListNode insertionSortList(ListNode head) {
        ListNode sorted = null;

        while (head != null) {
            // Remove an element from the input list
            ListNode node = head;
            head = node.next;
            node.next = null;

            // Find the location the node belongs within the sorted list and insert it there
            sorted = insertNode(sorted, node);
        }
        return sorted;
    }
}
