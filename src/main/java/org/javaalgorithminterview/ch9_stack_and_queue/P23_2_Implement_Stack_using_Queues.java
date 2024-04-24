package org.javaalgorithminterview.ch9_stack_and_queue;

import java.util.LinkedList;
import java.util.Queue;

public class P23_2_Implement_Stack_using_Queues {

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    ListNode root1;
    ListNode root2;

    public P23_2_Implement_Stack_using_Queues() {
    }

    /**
     * If the queue is empty, create a new node; otherwise, append a new node next to the rightmost node in natural order
     *
     */
    public void push(int x) {
        if (root1 == null) {
            root1 = new ListNode(x);

        } else {
            ListNode node = root1;

            while (node.next != null) {
                node = node.next;
            }
            node.next = new ListNode(x);
        }
    }

    /**
     * 1. Sort the Linked list in reversed order
     * 2. Remove the head node of from the list and return its value.
     */
    public int pop() {
        top();

        int value = root2.val;

        root2 = root2.next;

        return value;
    }

    /**
     * 1. Sort the linked list before retrieving the top value of the queue
     * 2. Sort the linked list named root1 in reverse order, then move it to another list name root2
     */
    public int top() {
        if (root1 == null && root2 != null) {
            return root2.val;
        } else if (root1 != null && root2 == null) {
            root2 = reverse(root1);
            root1 = null;
            return root2.val;
        } else if (root1 != null && root2 != null) {
            root1 = reverse(root1);
            ListNode temp = root1;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = root2;
            root2 = root1;
            root1 = null;
            return root2.val;
        } else {
            return -1;
        }
    }

    public ListNode reverse(ListNode root) {

        if (root == null || root.next == null) {
            return root;
        }

        ListNode slow = root;
        ListNode fast = root;
        ListNode half = null;

        while (fast != null && fast.next != null) {
            half = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        half.next = null;

        ListNode left = reverse(root);
        ListNode right = reverse(slow);

        ListNode temp = right;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = left;

        return right;
    }


    public boolean empty() {
        if (root1 == null && root2 == null) {
            return true;
        }
        return false;
    }
}
