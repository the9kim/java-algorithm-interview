package org.javaalgorithminterview.ch8_linked_list;

import java.util.Stack;

// Using a stack
public class P13_2_Palindrome_Linked_List {

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
     * 1. Add Nodes to the stack.
     * 2. Check if it is a Palindrome using the stack and the singly linked list.
     */

    public boolean isPalindrome(ListNode head) {

        // 1
        Stack<Integer> stack = new Stack<>();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp.val);
            temp = temp.next;
        }

        // 2
        while (!stack.isEmpty()) {
            if (stack.pop() != head.val) {
                return false;
            }
            head = head.next;
        }
        return true;
    }
}
