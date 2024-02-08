package org.javaalgorithminterview.ch8_linked_list;

public class P16_1_Add_Two_Numbers {

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

        public ListNode() {
        }
    }

    /**
     * 1. Sum each node in their lists
     * 2. Make an answer list
     * 3. Reverse the answer list.
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode sumNode = null;

        // 1 & 2
        int quotient = 0;
        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                int sum = l1.val + l2.val + quotient;
                int remainder = sum % 10;

                ListNode node = new ListNode(remainder);
                node.next = sumNode;
                sumNode = node;

                quotient = sum / 10;

                l1 = l1.next;
                l2 = l2.next;
            } else if (l1 != null && l2 == null) {
                int sum = l1.val + quotient;
                int remainder = sum % 10;

                ListNode node = new ListNode(remainder);
                node.next = sumNode;
                sumNode = node;

                quotient = sum / 10;
                l1 = l1.next;
            } else if (l1 == null && l2 != null) {
                int sum = l2.val + quotient;
                int remainder = sum % 10;

                ListNode node = new ListNode(remainder);
                node.next = sumNode;
                sumNode = node;

                quotient = sum / 10;
                l2 = l2.next;
            }
        }

        if (quotient == 1) {
            ListNode head = new ListNode(1);
            head.next = sumNode;
            sumNode = head;
        }



        // 3
        ListNode rev = null;

        while (sumNode != null) {
            ListNode next = sumNode.next;
            sumNode.next = rev;
            rev = sumNode;
            sumNode = next;
        }

        return rev;
    }

    /**
     * The answer the book suggests.
     *
     * 1. Sum each node value in their linked list.
     * 2. Make an answer list.
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode answer = new ListNode();
        ListNode temp = answer;

        int sum;
        int carry = 0;
        int remainder;

        while (l1 != null || l2 != null || carry == 1) {
            sum = 0;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            remainder = (sum + carry) % 10;
            carry = (sum + carry) / 10;

            temp.next = new ListNode(remainder);
            temp = temp.next;
        }
        return answer.next;
    }
}
