package org.javaalgorithminterview.ch8_linked_list;

// Using a Runner method
public class P13_4_Palindrome_Linked_List {

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
     * 1. Utilize the runner method
     * 2. When the fast pointer reaches to the end, adjust the slow pointer.
     * 3. Create a reverse linked list from the slow pointer using to the end of the remaining nodes.
     * 4. Compare the input linked list with the reverse lined list.
     */
    public boolean isPalindrome(ListNode head) {

        // 1
        ListNode fast = head;
        ListNode slow = head;

        // 2
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        if (fast != null) {
            slow = slow.next;
        }

        // 3
        ListNode rev = null;
        while (slow != null) {

            ListNode next = slow.next;
            slow.next = rev;

            rev = slow;
            slow = next;

        }

        // 4
        while (rev != null) {
            if (rev.val != head.val) {
                return false;
            }
            rev = rev.next;
            head = head.next;
        }

        return true;
    }
}
