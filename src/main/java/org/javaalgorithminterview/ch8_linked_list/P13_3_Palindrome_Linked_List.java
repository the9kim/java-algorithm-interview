package org.javaalgorithminterview.ch8_linked_list;

import java.util.Deque;
import java.util.LinkedList;

// Using a deque
public class P13_3_Palindrome_Linked_List {

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
     * 1. Add Nodes to the doubly linked list, deque.
     * 2. Check if it is a Palindrome from both sides.
     */
    public boolean isPalindrome(ListNode head) {
        Deque<Integer> stack = new LinkedList<>();

        ListNode temp = head;
        // 1.
        while (temp != null) {
            stack.add(temp.val);
            temp = temp.next;
        }

        // 2.
        while (!stack.isEmpty() && stack.size() > 1) {
            if (stack.pollFirst() != stack.pollLast()) {
                return false;
            }
        }

        return true;
    }
}
