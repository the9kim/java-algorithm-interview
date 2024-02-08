package org.javaalgorithminterview.ch8_linked_list;

import java.util.List;
import java.util.ArrayList;

public class P13_1_Palindrome_Linked_List {

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
     * 1. Convert the linked-list to an ArrayList.
     * 2. Check if the list is a palindrome.
     */
    public boolean isPalindrome(ListNode head) {

        List<Integer> values = new ArrayList<>();

        // 1
        ListNode temp = head;
        while (temp != null) {
            values.add(temp.val);
            temp = temp.next;
        }

        // 2
        int left = 0;
        int right = values.size() - 1;

        while (left < right) {
            if (values.get(left) != values.get(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
